package com.student.application.student_application.service;

import com.student.application.student_application.entity.MyProduct;
import com.student.application.student_application.filters.ProductFilter;

import java.util.List;

public interface MyProductService {
    public List<MyProduct> getProductsByFilter(ProductFilter filter);
}
