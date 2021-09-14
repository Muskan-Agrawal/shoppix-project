package com.muskan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.muskan")
@EnableJpaRepositories(basePackages="com.muskan.model.persistence")
@EntityScan(basePackages="com.muskan.bean")
public class CasestudyMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasestudyMvcProjectApplication.class, args);
	}

}
