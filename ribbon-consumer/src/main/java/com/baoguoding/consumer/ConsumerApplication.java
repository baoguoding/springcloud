package com.baoguoding.consumer;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "compute-service", configuration = TestConfiguration.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value=ExcludeFromComponentScan.class)})
public class ConsumerApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

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
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
