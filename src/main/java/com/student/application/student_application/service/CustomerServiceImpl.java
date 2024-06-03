package com.student.application.student_application.service;

import com.student.application.student_application.entity.Customer;
import com.student.application.student_application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void addCustomer(Customer customer) {
           customerRepository.save(customer);
    }
}
