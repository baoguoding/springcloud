package com.baoguoding.serviceproducter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProducterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProducterApplication.class, args);
	}

}
