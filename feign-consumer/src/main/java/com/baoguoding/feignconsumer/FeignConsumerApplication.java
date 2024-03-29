package com.baoguoding.feignconsumer;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class FeignConsumerApplication {

//	@Bean
//	Logger.Level feignLoggerLevel() {
//		return Logger.Level.FULL;
//	}

	@Bean
	public ServletRegistrationBean getServlet(){

		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);  //系统启动时加载顺序
		registrationBean.addUrlMappings("/hystrix.stream");//路径
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumerApplication.class, args);
	}

}
