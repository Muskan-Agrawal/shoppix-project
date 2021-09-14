package com.muskan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CongifServerShoppixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CongifServerShoppixApplication.class, args);
	}
}
