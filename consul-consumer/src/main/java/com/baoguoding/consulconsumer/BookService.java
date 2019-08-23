package com.baoguoding.consulconsumer;

import com.baoguoding.consulconsumer.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    @Autowired
    private RestTemplate restTemplate;

    @CacheResult(cacheKeyMethod = "getCacheKey2")
    @HystrixCommand
    public Book test6(Integer id, String aa) {
        return restTemplate.getForObject("http://service-producter/book/getbook5/{id}", Book.class, id);
    }

    @CacheResult(cacheKeyMethod = "getCacheKey2")
    @HystrixCommand
    public Book test6(Integer id) {
        return restTemplate.getForObject("http://service-producter/book/getbook5/{id}", Book.class, id);
    }

    public String getCacheKey2(Integer id) {
        return String.valueOf(id);
    }
}
