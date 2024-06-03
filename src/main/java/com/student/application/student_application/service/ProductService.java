package com.student.application.student_application.service;

import com.student.application.student_application.entity.Book;
import com.student.application.student_application.entity.Mobile;
import com.student.application.student_application.entity.Product;

import java.util.List;

public interface ProductService {

    public void addBook(Book book);

    public List<Book> getAllBooks();

    public void addMobile(Mobile mobile);

     public List<Mobile> getAllMobiles();
}
