package com.portkeeper.pkbackend.Data;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortDataService {
    private final PortDataRepository portDataRepository;

    public PortDataService(PortDataRepository portDataRepository) {
        this.portDataRepository = portDataRepository;
    }

    public List<PortData> getPorts() {
        return portDataRepository.findAll();
    }

    public void createPort(PortData portData) {
        portDataRepository.save(portData);
    }

    public void deletePort(Long portNumber) throws Exception {
        portDataRepository.delete(portDataRepository.findByPortNumber(portNumber));
    }

    @Transactional
    public void updatePort(Long portNumber, PortData secondPortData){
        PortData portData = portDataRepository.findByPortNumber(portNumber);
        portData.setPortService(secondPortData.getPortService());
    }
}
