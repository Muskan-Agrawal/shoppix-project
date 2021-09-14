package com.muskan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayShoppixApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayShoppixApplication.class, args);
	}

}
