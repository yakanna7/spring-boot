package com.student.application.student_application.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TransferDTO {
    String fromAccountNumber;
    String toAccountNumber;
    double amount;
}
