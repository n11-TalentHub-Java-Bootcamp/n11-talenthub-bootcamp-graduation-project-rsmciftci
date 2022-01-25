package com.example.n11talenthubbootcampgraduationprojectrsmciftci.controller;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerSavingDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditScoreService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CustomerService;
import lombok.AllArgsConstructor;
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
    public  CustomerDto save(@RequestBody @Valid CustomerSavingDto customerSavingDto){
        return customerService.save(customerSavingDto);
    }

    @PutMapping("")
    public CustomerDto update(@RequestBody @Valid CustomerDto customerDto){
        return customerService.update(customerDto);
    }

    @DeleteMapping("delete-by-{turkishIdentityNumber}&{dateOfBirth}")
    public ResponseEntity deleteCustomer(@PathVariable String turkishIdentityNumber, @PathVariable String dateOfBirth){
        return customerService.delete(turkishIdentityNumber,LocalDate.parse(dateOfBirth));
    }

    @GetMapping("{turkishIdentityNumber}") // TODO: creditScoru'n burada olması doğru mu?
    public String findCreditScoreEnum(@PathVariable String turkishIdentityNumber){
        return creditScoreService.getCreditScoreEnum(turkishIdentityNumber).toString();
    }





}
