package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter.CustomerMapper;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CustomerDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerSavingDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerDao customerDao;

    public CustomerDto save(CustomerSavingDto customerSavingDto){
        Customer customer = CustomerMapper.INSTANCE.convertCustomerSavingDtoToCustomer(customerSavingDto);
        customer = customerDao.save(customer);
        CustomerDto customerDto = CustomerMapper.INSTANCE.convertCustomerToCustomerDto(customer);
        return customerDto;
    }

    public CustomerDto update(CustomerDto customerDto){
        Customer customer = CustomerMapper.INSTANCE.convertCustomerDtoToCustomer(customerDto);
        customer = customerDao.save(customer);
        CustomerDto customerDtoSaved = CustomerMapper.INSTANCE.convertCustomerToCustomerDto(customer);
        return customerDto;
    }

    public ResponseEntity delete(String turkishIdentityNumber, LocalDate dateOfBirt){
        Optional<Customer> optionalCustomer = customerDao.findCustomerByTurkishIdentityNumberAndDateOfBirth(turkishIdentityNumber,dateOfBirt);
        if(optionalCustomer.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turkish identity number & date of birth didn't match with any customer.");
        }else{
            Customer customer = optionalCustomer.get();
            customerDao.delete(customer);
            return ResponseEntity.ok("Customer Successfully Deleted");
        }

    }
}
