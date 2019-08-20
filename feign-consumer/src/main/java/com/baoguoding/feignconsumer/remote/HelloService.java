package com.baoguoding.feignconsumer.remote;

import com.baoguoding.feignconsumer.DisableHystrixConfiguration;
import com.baoguoding.feignconsumer.FullLogConfiguation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient("compute-service")
//@FeignClient(name="compute-service", fallback=HelloServiceFallback.class)
//@FeignClient(name="compute-service",configuration= DisableHystrixConfiguration.class)
@FeignClient(name="compute-service", fallback=HelloServiceFallback.class, configuration= FullLogConfiguation.class)
public interface HelloService {
    @RequestMapping(value="/add", method = RequestMethod.GET)
    String hello(@RequestParam("a") Integer a, @RequestParam("b") Integer b, @RequestParam("sn") Integer sn);
}
