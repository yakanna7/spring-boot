package com.student.application.student_application.controller;


import com.student.application.student_application.entity.Account;
import com.student.application.student_application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @PostMapping("/save/{customerId}")
    public void saveAccount(@PathVariable Long customerId, @RequestBody  Account account) {
           accountService.addAccount(customerId, account);
    }
}
