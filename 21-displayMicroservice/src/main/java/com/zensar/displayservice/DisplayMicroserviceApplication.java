package com.zensar.displayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.zensar.displayservice.feign.client")

public class DisplayMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayMicroserviceApplication.class, args);
	}

}