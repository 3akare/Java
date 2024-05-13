package com.portkeeper.pkbackend.Data;

import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortServiceMappingService {
    private final PortServiceMappingRepository portServiceMappingRepository;

    public PortServiceMappingService(PortServiceMappingRepository portServiceMappingRepository){
        this.portServiceMappingRepository = portServiceMappingRepository;
    }

    public List<PortServiceMapping> getPortMappings() throws Exception{
        try{
            return portServiceMappingRepository.findAll();
        } catch (Exception e){
            throw new Exception("Error occurred while deleting port mapping", e);
        }
    }

    public void createPortMapping(PortServiceMapping portServiceMapping) throws Exception{
        try{
            portServiceMappingRepository.save(portServiceMapping);
        }catch (Exception e){
            throw new Exception("Error occurred while deleting port mapping", e);
        }
    }

    public void deletePortMapping(Long portNumber) throws EmptyResultDataAccessException, Exception {
        try {
            portServiceMappingRepository.delete(portServiceMappingRepository.findPortMappingByServicePortNumber(portNumber));
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("No port mapping found with the provided port number", 1);
        } catch (Exception e) {
            throw new Exception("Error occurred while deleting port mapping", e);
        }
    }

    @Transactional
    public void updatePortMapping(PortServiceMapping updatedPortMapping, Long servicePortNumber) throws EmptyResultDataAccessException, DataIntegrityViolationException, Exception {
        try {
            PortServiceMapping portData = portServiceMappingRepository.findPortMappingByServicePortNumber(servicePortNumber);
            portData.setAssociateService(updatedPortMapping.getAssociateService());
            portData.setServicePortNumber(updatedPortMapping.getServicePortNumber());
            portData.setServiceIpAddress(updatedPortMapping.getServiceIpAddress());
            portData.setServiceStatus(updatedPortMapping.getServiceStatus());
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("No port mapping found with the provided port number", 1);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Port mapping with the same port number already exists", e);
        } catch (Exception e) {
            throw new Exception("Error occurred while updating port mapping", e);
        }
    }
}
