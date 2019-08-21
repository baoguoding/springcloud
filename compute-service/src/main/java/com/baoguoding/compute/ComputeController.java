package com.baoguoding.compute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
public class ComputeController {
    Logger logger = LoggerFactory.getLogger(ComputeController.class);
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b, @RequestParam Integer sn) {
        Integer r = a + b;
//        try {
//            int sleepTime = new Random().nextInt(3000);
//            System.out.println("sleepTime=" + sleepTime);
//            Thread.sleep(sleepTime);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        logger.info("/add,  result:" + r + ",sn="+sn +",time="+ LocalDateTime.now());
        return r;
    }
}
