package com.portkeeper.pkbackend;

import com.portkeeper.pkbackend.Data.PortKeeperDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties(PortKeeperDto.class)
public class PortServiceMappingApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortServiceMappingApplication.class, args);
	}
}