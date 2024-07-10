package com.student.application.student_application.service;

import com.student.application.student_application.entity.MyProduct;
import com.student.application.student_application.filters.ProductFilter;
import com.student.application.student_application.repository.MyProductRepository;
import com.student.application.student_application.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService1")
@Primary

public class MyProductServiceImpl  implements  MyProductService{

    @Autowired
    MyProductRepository myProductRepository;
    @Override
    public List<MyProduct> getProductsByFilter(ProductFilter filter) {
        return myProductRepository.findAll(ProductSpecification.getProductsByFilter(filter));

    }
}
