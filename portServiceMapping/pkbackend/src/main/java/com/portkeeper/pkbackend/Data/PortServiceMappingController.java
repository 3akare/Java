package com.portkeeper.pkbackend.Data;


import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api/v1/port")
@SuppressWarnings("unused")
public class PortServiceMappingController {

    @Autowired
    private final PortServiceMappingService portServiceMappingService;

    public PortServiceMappingController(PortServiceMappingService portServiceMappingService){
        this.portServiceMappingService = portServiceMappingService;
    }

    @GetMapping
    public ResponseEntity<?> getPortMappings(){
        try{
            List<PortServiceMapping> portMappings = portServiceMappingService.getPortMappings();
            return ResponseEntity.ok(portMappings);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the port mappings.");
        }
    }

    @PostMapping
    public ResponseEntity<?> createPortMapping(@RequestBody PortServiceMapping portServiceMapping){
        try{
            portServiceMappingService.createPortMapping(portServiceMapping);
            return ResponseEntity.ok(List.of("Port mapping created successfully"));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A port mapping with the same port number already exists.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the port mapping.");
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletePortMapping(@PathParam("servicePortNumber") Long servicePortNumber){
        try{
            portServiceMappingService.deletePortMapping(servicePortNumber);
            return ResponseEntity.ok(List.of("Port mapping deleted successfully"));
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No port mapping found with the provided port number.");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the port mapping.");
        }

    }

    @PutMapping
    public ResponseEntity<?> updatePortMapping(@RequestBody PortServiceMapping updatedPortServiceMapping, @PathParam("servicePortNumber") Long servicePortNumber){
        try{
            portServiceMappingService.updatePortMapping(updatedPortServiceMapping, servicePortNumber);
            return ResponseEntity.ok(List.of("Port mapping updated successfully"));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No port mapping found with the provided port number.");
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A port mapping with the same port number exists.");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the port mapping.");
        }
    }
}
