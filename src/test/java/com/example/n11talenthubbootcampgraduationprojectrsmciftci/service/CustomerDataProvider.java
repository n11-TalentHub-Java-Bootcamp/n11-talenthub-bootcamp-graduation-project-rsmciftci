package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerSavingDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.validation.TurkishIdentityNumber;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerDataProvider {

    public static CustomerSavingDto getCustomerSavingDto() {

        CustomerSavingDto customerSavingDto = new CustomerSavingDto();

        customerSavingDto.setId(null);
        customerSavingDto.setTurkishIdentityNumber("32230419048");
        customerSavingDto.setName("Rasim");
        customerSavingDto.setMiddleName("");
        customerSavingDto.setSurname("Ciftci");
        customerSavingDto.setPhoneNumber("05413735686");
        customerSavingDto.setEmail("rsmciftci@gmail.com");
        customerSavingDto.setDateOfBirth(LocalDate.parse("1993-05-03"));
        customerSavingDto.setMonthlySalary(BigDecimal.valueOf(5000L));

        return customerSavingDto;
    }


    public static Customer getCustomer(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setTurkishIdentityNumber("32230419048");
        customer.setName("Rasim");
        customer.setMiddleName("");
        customer.setSurname("Ciftci");
        customer.setPhoneNumber("05413735686");
        customer.setEmail("rsmciftci@gmail.com");
        customer.setDateOfBirth(LocalDate.parse("1993-05-03"));
        customer.setMonthlySalary(BigDecimal.valueOf(5000.00));

        return customer;
    }

    public static CustomerDto getCustomerDto() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1L);
        customerDto.setTurkishIdentityNumber("32230419048");
        customerDto.setName("Rasim");
        customerDto.setMiddleName("");
        customerDto.setSurname("Ciftci");
        customerDto.setPhoneNumber("05413735686");
        customerDto.setEmail("rsmciftci@gmail.com");
        customerDto.setDateOfBirth(LocalDate.parse("1993-05-03"));
        customerDto.setMonthlySalary(BigDecimal.valueOf(5000.00));
        return customerDto;
    }
}
