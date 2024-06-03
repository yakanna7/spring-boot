package com.student.application.student_application.service;


import com.student.application.student_application.entity.Book;
import com.student.application.student_application.entity.Mobile;
import com.student.application.student_application.entity.Product;
import com.student.application.student_application.repository.BookRepository;
import com.student.application.student_application.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements  ProductService{

    @Autowired
    BookRepository bookRepository;

    @Autowired
    MobileRepository mobileRepository;
    @Override
    public void addBook(Book book) {
       bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks(){
         return bookRepository.findAll();
    }
    @Override
    public void addMobile(Mobile mobile) {
        mobileRepository.save(mobile);
    }

    @Override
    public List<Mobile> getAllMobiles() {
         return mobileRepository.findAll();
    }

}
