package com.student.application.student_application.controller;

import com.student.application.student_application.dto.TransferDTO;
import com.student.application.student_application.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transfers")
public class TransferController {
    @Autowired
    TransferService transferService;
    @PostMapping
    public void transferAmount(@RequestBody TransferDTO transferDTO) {
        transferService.transferAmount(transferDTO.getFromAccountNumber(), transferDTO.getToAccountNumber(), transferDTO.getAmount());
    }

}
