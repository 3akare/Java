package com.portkeeper.pkbackend.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortServiceMappingPropertyFile {
    private final Environment env;
    public PortServiceMappingPropertyFile(Environment env) {
        this.env = env;
    }

    @GetMapping("/propertyFile")
    public String getPropertyFile() {
        String[] activeProfiles = env.getActiveProfiles();
        String activeProfile = activeProfiles.length > 0 ? activeProfiles[0] : "default";

        return String.format("Active profile: %s\n", activeProfile);
    }
}
