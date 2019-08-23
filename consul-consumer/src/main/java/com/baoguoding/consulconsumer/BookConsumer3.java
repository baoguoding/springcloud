package com.baoguoding.consulconsumer;


import com.baoguoding.consulconsumer.model.Book;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer3")
public class BookConsumer3 {

    @Autowired
    private BookService bookService;

    @RequestMapping("/showbook6/{id}")
    public Book getbook6(@PathVariable("id") Integer id) {
        HystrixRequestContext.initializeContext();
        if(1 == 2) {
            //第一次发起请求
            Book b1 = bookService.test6(id, "");
            //参数和上次一致，使用缓存数据
            Book b2 = bookService.test6(id, "");
            //参数不一致，发起新请求
            Book b3 = bookService.test6(id, "aa");
        } else {
            //第一次发起请求
            Book b1 = bookService.test6(id);
            //参数和上次一致，使用缓存数据
            Book b2 = bookService.test6(id);
            //参数不一致，发起新请求
            Book b3 = bookService.test6(id);
        }

        return null;
    }
}
