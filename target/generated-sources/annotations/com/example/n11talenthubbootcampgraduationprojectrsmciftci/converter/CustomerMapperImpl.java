package com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerSavingDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-28T16:47:21+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer convertCustomerSavingDtoToCustomer(CustomerSavingDto customerSavingDto) {
        if ( customerSavingDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerSavingDto.getId() );
        customer.setTurkishIdentityNumber( customerSavingDto.getTurkishIdentityNumber() );
        customer.setName( customerSavingDto.getName() );
        customer.setMiddleName( customerSavingDto.getMiddleName() );
        customer.setSurname( customerSavingDto.getSurname() );
        customer.setPhoneNumber( customerSavingDto.getPhoneNumber() );
        customer.setEmail( customerSavingDto.getEmail() );
        customer.setDateOfBirth( customerSavingDto.getDateOfBirth() );
        customer.setMonthlySalary( customerSavingDto.getMonthlySalary() );

        return customer;
    }

    @Override
    public CustomerDto convertCustomerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setTurkishIdentityNumber( customer.getTurkishIdentityNumber() );
        customerDto.setName( customer.getName() );
        customerDto.setMiddleName( customer.getMiddleName() );
        customerDto.setSurname( customer.getSurname() );
        customerDto.setPhoneNumber( customer.getPhoneNumber() );
        customerDto.setEmail( customer.getEmail() );
        customerDto.setDateOfBirth( customer.getDateOfBirth() );
        customerDto.setMonthlySalary( customer.getMonthlySalary() );

        return customerDto;
    }

    @Override
    public Customer convertCustomerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );
        customer.setTurkishIdentityNumber( customerDto.getTurkishIdentityNumber() );
        customer.setName( customerDto.getName() );
        customer.setMiddleName( customerDto.getMiddleName() );
        customer.setSurname( customerDto.getSurname() );
        customer.setPhoneNumber( customerDto.getPhoneNumber() );
        customer.setEmail( customerDto.getEmail() );
        customer.setDateOfBirth( customerDto.getDateOfBirth() );
        customer.setMonthlySalary( customerDto.getMonthlySalary() );

        return customer;
    }

    @Override
    public Customer convertCreditApplicationDtoToCustomer(CreditApplicationDto creditApplicationDto) {
        if ( creditApplicationDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setTurkishIdentityNumber( creditApplicationDto.getTurkishIdentityNumber() );
        customer.setName( creditApplicationDto.getName() );
        customer.setMiddleName( creditApplicationDto.getMiddleName() );
        customer.setSurname( creditApplicationDto.getSurname() );
        customer.setPhoneNumber( creditApplicationDto.getPhoneNumber() );
        customer.setEmail( creditApplicationDto.getEmail() );
        customer.setDateOfBirth( creditApplicationDto.getDateOfBirth() );
        customer.setMonthlySalary( creditApplicationDto.getMonthlySalary() );

        return customer;
    }
}
