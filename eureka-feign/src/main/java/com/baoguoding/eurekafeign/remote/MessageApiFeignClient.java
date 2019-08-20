package com.baoguoding.eurekafeign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "message-api",fallbackFactory = MessageApiFailFactory.class)
public interface MessageApiFeignClient {
    @RequestMapping(value = "/example/hello",method = RequestMethod.GET)
    public String getMessage(@RequestParam("name") String name);
}
