package com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerSavingDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer convertCustomerSavingDtoToCustomer(CustomerSavingDto customerSavingDto);

    CustomerDto convertCustomerToCustomerDto(Customer customer);

    Customer convertCustomerDtoToCustomer(CustomerDto customerDto);
}