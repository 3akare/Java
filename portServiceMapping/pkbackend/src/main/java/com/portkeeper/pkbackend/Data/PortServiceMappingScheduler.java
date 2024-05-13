package com.portkeeper.pkbackend.Data;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

@Component
public class PortServiceMappingScheduler {

    private final PortServiceMappingRepository portServiceMappingRepository;

    public PortServiceMappingScheduler(PortServiceMappingRepository portServiceMappingRepository) {
        this.portServiceMappingRepository = portServiceMappingRepository;
    }

    @Scheduled(cron = "*/5 * * * * *")
    @Transactional
    public void cron() throws Exception {
        List<PortServiceMapping> portServiceMappingList = portServiceMappingRepository.findAll();

        for (PortServiceMapping portServiceMapping : portServiceMappingList) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress("www." + portServiceMapping.getServiceIpAddress(), portServiceMapping.getServicePortNumber().intValue()), 1000);
//                System.out.println(portServiceMapping.getServiceIpAddress());
//                System.out.println(portServiceMapping.getServicePortNumber());
//                portServiceMapping.setServiceStatus(PortServiceMappingStatus.ACTIVE);
//                System.out.println("good");
            } catch (Exception ignored) {
                portServiceMapping.setServiceStatus(PortServiceMappingStatus.INACTIVE);
//                System.out.println("bad");
            }
        }
    }
}

