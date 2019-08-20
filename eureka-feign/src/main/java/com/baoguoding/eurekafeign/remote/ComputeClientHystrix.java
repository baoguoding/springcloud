package com.baoguoding.eurekafeign.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b, @RequestParam("sn") Integer sn) {
        return -9999;
    }
}
