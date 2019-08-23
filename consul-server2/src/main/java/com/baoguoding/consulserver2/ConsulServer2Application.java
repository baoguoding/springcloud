package com.baoguoding.consulserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulServer2Application {

	@RequestMapping("/home")
	public Object home() {
		System.out.println("cloud-server2");
		return "cloud-server2";
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsulServer2Application.class, args);
	}

}
