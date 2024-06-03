package com.student.application.student_application.service;


import com.student.application.student_application.entity.Account;
import com.student.application.student_application.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferServiceImpl  implements TransferService{

    @Autowired
    AccountRepository accountRepository;


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void transferAmount(String fromAccountNumber, String toAccountNumber, double amount) {


        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
        Account toAccount =  accountRepository.findByAccountNumber(toAccountNumber);

        if(fromAccount == null || toAccount == null) {
             throw new IllegalArgumentException("Account not found");
        }

        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);

        accountRepository.save(toAccount);

    }
}
