package com.student.application.student_application.controller;

import com.student.application.student_application.dto.TransferDTO;
import com.student.application.student_application.service.TransferService;
import com.student.application.student_application.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transfers")
@Slf4j
public class TransferController {
    @Autowired
    TransferService transferService;
    @PostMapping
    public void transferAmount(@RequestBody TransferDTO transferDTO) {
       if(log.isDebugEnabled()) {
           log.debug("transferAmount request is : {}", JsonUtils.toJson(transferDTO));

       }
        transferService.transferAmount(transferDTO.getFromAccountNumber(), transferDTO.getToAccountNumber(), transferDTO.getAmount());
    }

}
