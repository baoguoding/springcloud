package com.baoguoding.serviceproducter;

import com.baoguoding.serviceproducter.model.Book;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookProducter {

    @RequestMapping(value = "/getbook5/{id}", method = RequestMethod.GET)
    public Book getbook5(@PathVariable Integer id) {
        System.out.println(">>>>>>>>/getbook5/" + id);
        if (id == 1) {
            return new Book(id, "《李自成》", 55, "姚雪垠", "人民文学出版社");
        } else if (id == 2) {
            return new Book(id, "中国文学简史", 33, "林庚", "清华大学出版社");
        }
        return new Book(id, "文学改良刍议", 33, "胡适", "无");
    }
}
