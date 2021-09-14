package com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.order.service.OrderService;


@SpringBootApplication(scanBasePackages = "com.order")
@EntityScan(basePackages = "com.order.bean")
@EnableJpaRepositories(basePackages = "com.order.persistence")
@EnableEurekaClient
public class OrderServiceApplication /*implements CommandLineRunner*/ {

	@Autowired 
	OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		List<OrderItems> orderItems = new ArrayList<OrderItems>();
//		orderItems.add(new OrderItems(14L, 1));
//		orderItems.add(new OrderItems(58L,1));
//		orderItems.add(new OrderItems(63L,1));
//		orderService.createOrder(new Orders("messopotima@gmail.com", "Main HDFC Branch, Vaishali, Jaipur", orderItems));
//	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}


