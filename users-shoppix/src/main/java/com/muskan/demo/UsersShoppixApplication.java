package com.muskan.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.muskan.bean.User;
import com.muskan.service.UserService;

@SpringBootApplication(scanBasePackages = "com.muskan")
@EnableJpaRepositories(basePackages = "com.muskan.persistence")
@EntityScan(basePackages = "com.muskan.bean")
@EnableEurekaClient
public class UsersShoppixApplication /*implements CommandLineRunner*/ {
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(UsersShoppixApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		userService.insertUser(new User(1, "Muskan", "Visakhapatnam, India", "password"));
//        userService.insertUser(new User(2, "Pranshu", "Delhi, India", "password"));
//        userService.insertUser(new User(3, "Chaithanya", "Mumbai, India", "password"));
//        userService.insertUser(new User(4, "Vrinda", "Hyderabad, India", "password"));
//        userService.insertUser(new User(5, "Hari", "Visakhapatnam, India", "password"));
//        userService.insertUser(new User(6, "Ravi", "Mumbai, India", "password"));
//	}
}
