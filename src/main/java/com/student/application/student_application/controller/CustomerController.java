package com.student.application.student_application.controller;

import com.student.application.student_application.entity.Customer;
import com.student.application.student_application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/save")
    public void saveCustomer(@RequestBody Customer customer) {
            customerService.addCustomer(customer);
    }
}
