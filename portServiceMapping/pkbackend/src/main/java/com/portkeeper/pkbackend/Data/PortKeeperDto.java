package com.portkeeper.pkbackend.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "keeper")
public record PortKeeperDto(String Message, Map<String, String> contactDetails, List<String> onCallSupport) {
}
