package com.baoguoding.consulconsumer;

import com.baoguoding.consulconsumer.model.Book;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

public class BookCommand  extends HystrixCommand<Book> {

    private RestTemplate restTemplate;
    private Integer id;

    @Override
    protected Book getFallback() {
        Throwable executionException = getExecutionException();
        System.out.println(executionException.getMessage());
        return new Book("宋诗选注", 88, "钱钟书", "三联书店");
    }

    @Override
    protected Book run() throws Exception {
        System.out.println("======id:"+id);
        return restTemplate.getForObject("http://service-producter/book/getbook5/{id}", Book.class, id);
    }

    public BookCommand(Setter setter, RestTemplate restTemplate, Integer id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }
}
