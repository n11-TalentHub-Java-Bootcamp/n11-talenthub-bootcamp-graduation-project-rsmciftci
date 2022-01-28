package com.example.n11talenthubbootcampgraduationprojectrsmciftci.controller;


import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerSavingDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditScoreService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CustomerService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.SmsService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/customers/")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;
    private CreditScoreService creditScoreService;



    @PostMapping("")
    public Customer save(@RequestBody @Valid CustomerSavingDto customerSavingDto){
        return customerService.save(customerSavingDto);
    }

    @PutMapping("")
    public Customer update(@RequestBody @Valid CustomerDto customerDto){
        return customerService.update(customerDto);
    }

    @DeleteMapping("delete-by-{turkishIdentityNumber}&{dateOfBirth}")
    public ResponseEntity deleteCustomer(@PathVariable String turkishIdentityNumber, @PathVariable String dateOfBirth){
        return customerService.delete(turkishIdentityNumber,LocalDate.parse(dateOfBirth));
    }

    @GetMapping("{turkishIdentityNumber}")
    public String findCreditScoreEnum(@PathVariable String turkishIdentityNumber){
        return creditScoreService.getCreditScoreEnum(turkishIdentityNumber).toString();
    }







}
