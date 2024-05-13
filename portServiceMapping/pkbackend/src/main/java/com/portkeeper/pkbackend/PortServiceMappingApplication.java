package com.portkeeper.pkbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PortServiceMappingApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortServiceMappingApplication.class, args);
	}
}