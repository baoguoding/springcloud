package com.baoguoding.eurekafeign.service;

import com.baoguoding.eurekafeign.remote.MessageApiFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageApiFeignClient messageApiFeignClient;

    @RequestMapping(value="/message", method = RequestMethod.GET)
    public String message() {
        return messageApiFeignClient.getMessage("zhangsan");
    }
}
