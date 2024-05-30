package com.portkeeper.pkbackend.Data;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.*;

@RestController
@RequestMapping("/email")
@Component
public class PortServiceMappingScheduler {
    private final PortServiceMappingEmailSender portServiceMappingEmailSender;
    private final PortServiceMappingRepository portServiceMappingRepository;
    private Map<String,String> downBad = new HashMap<>();

    public PortServiceMappingScheduler(PortServiceMappingRepository portServiceMappingRepository, PortServiceMappingEmailSender portServiceMappingEmailSender, Map<String,String> downBad) {
        this.portServiceMappingRepository = portServiceMappingRepository;
        this.portServiceMappingEmailSender = portServiceMappingEmailSender;
        this.downBad = downBad;
    }

    @Scheduled(cron = "*/5 * * * * *")
    @Transactional
    public void cron() throws Exception {
        List<PortServiceMapping> portServiceMappingList = portServiceMappingRepository.findAll();
        for (PortServiceMapping portServiceMapping : portServiceMappingList) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(portServiceMapping.getServiceIpAddress(), portServiceMapping.getServicePortNumber().intValue()), 1000);
                portServiceMapping.setServiceStatus(PortServiceMappingStatus.ACTIVE);
            } catch (Exception ignored) {
                portServiceMapping.setServiceStatus(PortServiceMappingStatus.INACTIVE);
                if (portServiceMapping.getServiceStatus() == PortServiceMappingStatus.INACTIVE){
                    if (!downBad.containsKey(portServiceMapping.getMappingId().toString())) {
                        downBad.put(portServiceMapping.getMappingId().toString(), "unsent");
                    }
                }
            }
        }
    }

    @Scheduled(cron = "0 */1 * ? * *")
    public void cronEmail(){
        System.out.println("this ran!");
        for (Map.Entry<String,String> entry : downBad.entrySet()){
            if (Objects.equals(entry.getValue(), "unsent")) {
                PortServiceMapping portServiceMapping = portServiceMappingRepository.findById(Long.parseLong(entry.getKey())).get();
                portServiceMappingEmailSender.sendEmail(portServiceMapping);
                System.out.println("Success");
                downBad.replace(entry.getKey(), "sent");
            }
        }
    }
}

