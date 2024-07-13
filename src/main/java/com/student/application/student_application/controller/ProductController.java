package com.student.application.student_application.controller;


import com.student.application.student_application.entity.Book;
import com.student.application.student_application.entity.Mobile;
import com.student.application.student_application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/book")
    public void addBook(@RequestBody  Book book) {
        productService.addBook(book);
    }


    @PostMapping("/mobile")
    public void addMobile(@RequestBody Mobile mobile){
        productService.addMobile(mobile);
    }


    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return productService.getAllBooks();
    }

    @GetMapping("/mobiles")
    public List<Mobile> getAllMobiles(){
        return productService.getAllMobiles();
    }

}

