package com.example.n11talenthubbootcampgraduationprojectrsmciftci.controller;


import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerSavingDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditScoreService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CustomerService;
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
    public ResponseEntity save(@RequestBody @Valid CustomerSavingDto customerSavingDto){

        CustomerDto customerDto = customerService.save(customerSavingDto);
        return ResponseEntity.ok(customerDto);
    }

    @PutMapping("")
    public ResponseEntity update(@RequestBody @Valid CustomerDto customerDto){
        CustomerDto savedCustomerDto = customerService.update(customerDto);
        return ResponseEntity.ok(savedCustomerDto);
    }

    @DeleteMapping("delete-by-{turkishIdentityNumber}&{dateOfBirth}")
    public void deleteCustomer(@PathVariable String turkishIdentityNumber, @PathVariable String dateOfBirth){
        customerService.delete(turkishIdentityNumber,LocalDate.parse(dateOfBirth));
    }

    @GetMapping("{turkishIdentityNumber}") // TODO: creditScoru'n burada olması doğru mu?
    public String findCreditScoreEnum(@PathVariable String turkishIdentityNumber){
        return creditScoreService.getCreditScoreEnum(turkishIdentityNumber).toString();
    }







}
