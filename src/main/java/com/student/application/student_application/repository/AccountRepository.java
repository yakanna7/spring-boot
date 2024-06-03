package com.student.application.student_application.repository;

import com.student.application.student_application.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository  extends JpaRepository<Account,Long> {

       Account findByAccountNumber(String accountNumber);
}
