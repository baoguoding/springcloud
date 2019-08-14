package com.baoguoding.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    private AtomicInteger sn = new AtomicInteger(0);
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(@RequestParam Integer a, @RequestParam Integer b) {// 将原来的ip:port的形式，改成注册到Eureka Server上的应用名即可
        System.out.println("==============================");
        String result = restTemplate.getForObject("http://compute-service/add?a="+a +"&b="+b + "&sn="+sn.incrementAndGet(), String.class);
        System.out.println("返回结果:" + result);
    }
}
