package com.baoguoding.consulconsumer;

import com.baoguoding.consulconsumer.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer2")
public class BookConsumer2 {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/showbook6/{id}")
    public Book getbook6(@PathVariable("id") Integer id) {
        HystrixRequestContext.initializeContext();
        //第一次发起请求
        Book b1 = test6(id, "");
        //参数和上次一致，使用缓存数据
        Book b2 = test6(id, "");
        //参数不一致，发起新请求
        Book b3 = test6(id, "aa");
        return b1;
    }

    @CacheResult(cacheKeyMethod = "getCacheKey2")
    @HystrixCommand
    public Book test6(Integer id, String aa) {
        return restTemplate.getForObject("http://service-producter/book/getbook5/{id}", Book.class, id);
    }

    public String getCacheKey2(Integer id) {
        return String.valueOf(id);
    }
}