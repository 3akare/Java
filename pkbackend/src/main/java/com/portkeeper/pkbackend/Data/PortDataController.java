package com.portkeeper.pkbackend.Data;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/port")
public class PortDataController {

    @Autowired
    private final PortDataService portDataService;

    public PortDataController(PortDataService portDataService){
        this.portDataService = portDataService;
    }

    @GetMapping
    public List<PortData> getPort(){
        return portDataService.getPorts();
    }

    @PostMapping
    public ResponseEntity<List<String>> createPort(@RequestBody PortData portData) throws URISyntaxException{
        portDataService.createPort(portData);
        return ResponseEntity.ok(List.of("success"));
    }

    @DeleteMapping
    public ResponseEntity<List<String>> createPort(@PathParam("portNumber") Long portNumber) throws Exception {
        portDataService.deletePort(portNumber);
        return ResponseEntity.ok(List.of("success"));
    }

    @PutMapping
    public ResponseEntity<List<String>> updatePort(@PathParam("portNumber") Long portNumber, @RequestBody PortData portData){
        portDataService.updatePort(portNumber, portData);
        return ResponseEntity.ok(List.of("success"));
    }
}
