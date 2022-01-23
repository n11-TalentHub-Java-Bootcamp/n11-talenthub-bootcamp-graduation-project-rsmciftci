package com.example.n11talenthubbootcampgraduationprojectrsmciftci.controller;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationResultDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditScoreService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/credit-application/")
@AllArgsConstructor
public class CustomerCreditApplicationController {

    private CustomerService customerService;
    private CreditScoreService creditScoreService;
    private CreditService creditService;

    @PostMapping("")
    public CreditApplicationResultDto saveCreditApplicationIfCustomerExistsIfNotSaveCustomerThenCreditApplicationAndSendSMS(@RequestBody @Valid CreditApplicationDto creditApplicationDto){
        CreditApplicationResultDto creditApplicationResultDto = creditService.saveCreditApplicationIfCustomerExistsIfNotSaveCustomerThenCreditApplicationAndSendSMS(creditApplicationDto);
        return creditApplicationResultDto;
    }




}
