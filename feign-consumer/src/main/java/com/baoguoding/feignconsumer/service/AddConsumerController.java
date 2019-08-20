package com.baoguoding.feignconsumer.service;

import com.baoguoding.feignconsumer.remote.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class AddConsumerController {

    @Autowired
    HelloService helloService;

    private AtomicInteger sn = new AtomicInteger(0);

    @RequestMapping(value="/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(@RequestParam Integer a, @RequestParam Integer b) {
        return helloService.hello(a, b, sn.incrementAndGet());
    }
}
