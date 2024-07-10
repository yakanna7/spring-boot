package com.student.application.student_application.service;

import com.student.application.student_application.entity.MyProduct;
import com.student.application.student_application.filters.ProductFilter;
import com.student.application.student_application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("productService2")
public class MyProductServiceImpl1  implements  MyProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<MyProduct> getProductsByFilter(ProductFilter filter) {
        return productRepository.findProductsByFilter(filter);
    }
}
