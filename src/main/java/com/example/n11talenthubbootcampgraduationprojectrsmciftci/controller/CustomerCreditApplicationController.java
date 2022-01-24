package com.example.n11talenthubbootcampgraduationprojectrsmciftci.controller;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationResultDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditScoreService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CustomerService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/credit-application/")
@AllArgsConstructor
//@Validated
public class CustomerCreditApplicationController {

    private CustomerService customerService;
    private CreditScoreService creditScoreService;
    private CreditService creditService;

    @PostMapping("")
    public CreditApplicationResultDto saveCreditApplicationIfCustomerExistsIfNotSaveCustomerThenCreditApplicationAndSendSMS(@RequestBody @Valid CreditApplicationDto creditApplicationDto) {
        CreditApplicationResultDto creditApplicationResultDto = creditService.saveCreditApplicationIfCustomerExistsIfNotSaveCustomerThenCreditApplicationAndSendSMS(creditApplicationDto);
        return creditApplicationResultDto;
    }


    @GetMapping("by-{turkishIdentityNumber}&{dateOfBirth}")
    public ResponseEntity findCreditApplication(@PathVariable("turkishIdentityNumber") String turkishIdentityNumber,
                                                @PathVariable("dateOfBirth") String dateOfBirth) {

        return creditService.findCreditApplication(turkishIdentityNumber, LocalDate.parse(dateOfBirth));


    }
}