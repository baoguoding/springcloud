package com.baoguoding.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;


@Service
public class ComputeService {
    @Autowired
    RestTemplate restTemplate;

    private AtomicInteger sn = new AtomicInteger(0);
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20&sn=1 + &sn="+sn.incrementAndGet(), String.class).getBody();
    }

    public String addServiceFallback() {
        return "error";
    }
}
