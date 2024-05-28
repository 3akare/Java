package com.portkeeper.pkbackend.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortServiceMappingPropertyFile {
    private final Environment env;
    private final PortKeeperDto portKeeperDto;

    public PortServiceMappingPropertyFile(Environment env, PortKeeperDto portKeeperDto) {
        this.env = env;
        this.portKeeperDto = portKeeperDto;
    }

    @GetMapping("/propertyFile")
    public ResponseEntity<PortKeeperDto> getPropertyFile() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(portKeeperDto);
    }
}
