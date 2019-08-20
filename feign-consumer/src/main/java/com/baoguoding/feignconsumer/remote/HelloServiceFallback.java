package com.baoguoding.feignconsumer.remote;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello(Integer a, Integer b, Integer sn) {
        System.out.println("HelloServiceFallback");
        return "fallback";
    }

}