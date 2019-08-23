package com.baoguoding.consulconsumer;

import com.baoguoding.consulconsumer.model.Book;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class BookConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/showbook5/{id}", method = RequestMethod.GET)
    public Book getbook5(@PathVariable("id") Integer id) {
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("commandKey");
        HystrixRequestContext.initializeContext();
        BookCommand bc1 = new BookCommand(
                HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")).andCommandKey(commandKey),
                restTemplate, id);
        Book e1 = bc1.execute();
        BookCommand bc2 = new BookCommand(
                HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")).andCommandKey(commandKey),
                restTemplate, id);
        Book e2 = bc2.execute();
        BookCommand bc3 = new BookCommand(
                HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")).andCommandKey(commandKey),
                restTemplate, id);
        Book e3 = bc3.execute();
        System.out.println("e1:" + e1);
        System.out.println("e2:" + e2);
        System.out.println("e3:" + e3);
        System.out.println("-------------------");
        return e1;
    }
}