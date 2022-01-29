package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;



import com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter.CustomerMapper;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CustomerDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerSavingDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldSave(){
        CustomerSavingDto customerSavingDto = CustomerDataProvider.getCustomerSavingDto();
        Customer customerSaved = CustomerMapper.INSTANCE.convertCustomerSavingDtoToCustomer(customerSavingDto);
        customerSaved.setId(1L);
        when(customerDao.save(ArgumentMatchers.any(Customer.class))).thenReturn(customerSaved);
        Customer result = customerService.save(customerSavingDto);

        assertEquals(customerSaved,result);
        assertEquals(1L, result.getId());
    }

    @Test
    void shouldUpdate(){
        Customer customerUpdated = CustomerDataProvider.getCustomer();
        when(customerDao.save(ArgumentMatchers.any(Customer.class))).thenReturn(customerUpdated);

        CustomerDto customerDto = CustomerDataProvider.getCustomerDto();
        Customer result = customerService.update(customerDto);

        assertEquals(customerUpdated,result);
    }


    @Test
    void shouldDelete(){

        Customer customer = CustomerDataProvider.getCustomer();
        when(customerDao.findCustomerByTurkishIdentityNumberAndDateOfBirth("41009520922",LocalDate.parse("1993-05-03")))
                .thenReturn(Optional.of(customer));

        assertTrue(Optional.of(customer).isPresent());

        customerService.delete("41009520922",LocalDate.parse("1993-05-03"));
        verify(customerDao).findCustomerByTurkishIdentityNumberAndDateOfBirth("41009520922",LocalDate.parse("1993-05-03"));
        verify(customerDao).delete(customer);

    }

    @Test
    void shouldNotDeleteWhenCustomerIsNotSavedOrTurkishIdentityNumberAndDateOfBirthDoesntMatch(){

        Optional<Customer> optionalCustomer = Optional.ofNullable(null);
        when(customerDao.findCustomerByTurkishIdentityNumberAndDateOfBirth("41009520922",LocalDate.parse("1993-05-03")))
                .thenReturn(optionalCustomer);

        assertFalse(optionalCustomer.isPresent());

        customerService.delete("41009520922",LocalDate.parse("1993-05-03"));
        verify(customerDao).findCustomerByTurkishIdentityNumberAndDateOfBirth("41009520922",LocalDate.parse("1993-05-03"));



    }


}