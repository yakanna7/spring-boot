package com.student.application.student_application.service;

import com.student.application.student_application.entity.Account;
import com.student.application.student_application.entity.Customer;
import com.student.application.student_application.repository.AccountRepository;
import com.student.application.student_application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl  implements AccountService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public void addAccount(Long customerId, Account account) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer does not exist with id " + customerId));
        account.setCustomer(customer);
        accountRepository.save(account);
    }
}
