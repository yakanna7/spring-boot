package com.student.application.student_application.controller;


import com.student.application.student_application.entity.MyProduct;
import com.student.application.student_application.filters.ProductFilter;
import com.student.application.student_application.service.MyProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/myproducts")
public class MyProductController {
    @Autowired
    //@Qualifier("productService2")
    MyProductService myProductService;
    @GetMapping("/filters")
    public List<MyProduct> getProductsByFilter(@RequestBody  ProductFilter filter){
        return myProductService.getProductsByFilter(filter);
    }

}
