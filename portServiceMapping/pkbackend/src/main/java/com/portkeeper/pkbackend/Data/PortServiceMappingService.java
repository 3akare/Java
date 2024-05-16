package com.portkeeper.pkbackend.Data;

import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
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
            PortServiceMapping checker = portServiceMappingRepository.findPortMappingByServicePortNumberAndServiceIpAddress(portServiceMapping.getServicePortNumber(), portServiceMapping.getServiceIpAddress());
            System.out.println(checker.toString());
        }
        catch (NullPointerException e){
            portServiceMappingRepository.save(portServiceMapping);
            return;
        }
        throw new DataIntegrityViolationException("PortMapping Object already Exists");
    }

    public void deletePortMapping(Long portNumber, String serviceIpAddress) throws EmptyResultDataAccessException, Exception {
        try {
            portServiceMappingRepository.delete(portServiceMappingRepository.findPortMappingByServicePortNumberAndServiceIpAddress(portNumber, serviceIpAddress));
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("No port mapping found with the provided port number", 1);
        } catch (Exception e) {
            throw new Exception("Error occurred while deleting port mapping", e);
        }
    }

    @Transactional
    public void updatePortMapping(PortServiceMapping updatedPortMapping, Long servicePortNumber, String serviceIpAddress) throws EmptyResultDataAccessException, DataIntegrityViolationException, Exception {
        try {
            PortServiceMapping portData = portServiceMappingRepository.findPortMappingByServicePortNumberAndServiceIpAddress(servicePortNumber, serviceIpAddress);
            portData.setAssociateService(updatedPortMapping.getAssociateService());
            portData.setServicePortNumber(updatedPortMapping.getServicePortNumber());
            portData.setServiceIpAddress(updatedPortMapping.getServiceIpAddress());
            portData.setServiceStatus(updatedPortMapping.getServiceStatus());
            portData.setJavaVersion(updatedPortMapping.getJavaVersion());
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("No port mapping found with the provided port number", 1);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Port mapping with the same port number already exists", e);
        } catch (Exception e) {
            throw new Exception("Error occurred while updating port mapping", e);
        }
    }
}
