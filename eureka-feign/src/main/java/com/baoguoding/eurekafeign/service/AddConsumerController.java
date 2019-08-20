package com.baoguoding.eurekafeign.service;

import com.baoguoding.eurekafeign.remote.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class AddConsumerController {

    @Autowired
    ComputeClient computeClient;

    private AtomicInteger sn = new AtomicInteger(0);
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public Integer helloConsumer(@RequestParam Integer a, @RequestParam Integer b) {
        return computeClient.add(a, b,sn.incrementAndGet());
    }
}
