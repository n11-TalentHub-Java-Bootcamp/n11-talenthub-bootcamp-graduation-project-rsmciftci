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
        customerSavingDto.setTurkishIdentityNumber("41009520922");
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
        customer.setTurkishIdentityNumber("41009520922");
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
        customerDto.setTurkishIdentityNumber("41009520922");
        customerDto.setName("Rasim");
        customerDto.setMiddleName("");
        customerDto.setSurname("Ciftci");
        customerDto.setPhoneNumber("05413735686");
        customerDto.setEmail("rsmciftci@gmail.com");
        customerDto.setDateOfBirth(LocalDate.parse("1993-05-03"));
        customerDto.setMonthlySalary(BigDecimal.valueOf(5000.00));
        return customerDto;
    }

    public static Customer getCustomerCreditScoreLowerThan500(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setTurkishIdentityNumber("63488754308");
        customer.setName("Rasim");
        customer.setMiddleName("");
        customer.setSurname("Ciftci");
        customer.setPhoneNumber("05413735686");
        customer.setEmail("rsmciftci@gmail.com");
        customer.setDateOfBirth(LocalDate.parse("1993-05-03"));
        customer.setMonthlySalary(BigDecimal.valueOf(5000.00));

        return customer;
    }

    public static Customer getCustomerCreditScoreHigherThan999(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setTurkishIdentityNumber("97180504992");
        customer.setName("Rasim");
        customer.setMiddleName("");
        customer.setSurname("Ciftci");
        customer.setPhoneNumber("05413735686");
        customer.setEmail("rsmciftci@gmail.com");
        customer.setDateOfBirth(LocalDate.parse("1993-05-03"));
        customer.setMonthlySalary(BigDecimal.valueOf(5000.00));

        return customer;
    }



    public static Customer CreditScore500To1000AndSalaryLowerThan5k(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setTurkishIdentityNumber("20611333458");
        customer.setName("Rasim");
        customer.setMiddleName("");
        customer.setSurname("Ciftci");
        customer.setPhoneNumber("05413735686");
        customer.setEmail("rsmciftci@gmail.com");
        customer.setDateOfBirth(LocalDate.parse("1993-05-03"));
        customer.setMonthlySalary(BigDecimal.valueOf(4000.00));

        return customer;
    }

    public static Customer CreditScore500To1000AndSalary5kTo10k() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setTurkishIdentityNumber("20611333458");
        customer.setName("Rasim");
        customer.setMiddleName("");
        customer.setSurname("Ciftci");
        customer.setPhoneNumber("05413735686");
        customer.setEmail("rsmciftci@gmail.com");
        customer.setDateOfBirth(LocalDate.parse("1993-05-03"));
        customer.setMonthlySalary(BigDecimal.valueOf(7000.00));
        return customer;


    }

    public static Customer CreditScore500To1000AndSalaryHigherThan9999() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setTurkishIdentityNumber("20611333458");
        customer.setName("Rasim");
        customer.setMiddleName("");
        customer.setSurname("Ciftci");
        customer.setPhoneNumber("05413735686");
        customer.setEmail("rsmciftci@gmail.com");
        customer.setDateOfBirth(LocalDate.parse("1993-05-03"));
        customer.setMonthlySalary(BigDecimal.valueOf(15000.00));
        return customer;
    }
}
