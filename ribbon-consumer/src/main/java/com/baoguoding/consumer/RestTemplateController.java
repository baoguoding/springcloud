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

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ComputeService computeService;

    private AtomicInteger sn = new AtomicInteger(0);
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        Long start = System.currentTimeMillis();
        String temp = computeService.addService();
        Long end = System.currentTimeMillis();
        System.out.println("computeService.addService()="+temp + ",user time=" +(end-start) + "毫秒");
        return temp;
    }
}
