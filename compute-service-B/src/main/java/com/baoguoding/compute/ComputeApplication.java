package com.baoguoding.compute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ComputeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputeApplication.class, args);
	}

}
