package com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Credit;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory.CreditProducedInFactory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditMapper {
    CreditMapper INSTANCE = Mappers.getMapper(CreditMapper.class);


    Credit convertCreditProducedFactoryToCredit(CreditProducedInFactory creditProducedInFactory);
}
