package com.meetyourteam.mytbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MeetyourteamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetyourteamApplication.class, args);
	}
}
