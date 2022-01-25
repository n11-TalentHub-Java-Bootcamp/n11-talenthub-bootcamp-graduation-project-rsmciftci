package com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationResultDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Credit;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory.CreditProducedInFactory;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-25T16:52:32+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
public class CreditMapperImpl implements CreditMapper {

    @Override
    public Credit convertCreditProducedFactoryToCredit(CreditProducedInFactory creditProducedInFactory) {
        if ( creditProducedInFactory == null ) {
            return null;
        }

        Credit credit = new Credit();

        credit.setPledgeValue( creditProducedInFactory.getPledgeValue() );
        credit.setCreditLimit( creditProducedInFactory.getCreditLimit() );
        credit.setCreditResultEnum( creditProducedInFactory.getCreditResultEnum() );
        credit.setCreditScore( creditProducedInFactory.getCreditScore() );
        credit.setCustomer( creditProducedInFactory.getCustomer() );

        return credit;
    }

    @Override
    public CreditApplicationResultDto convertCreditToCreditApplicationResultDto(Credit credit) {
        if ( credit == null ) {
            return null;
        }

        CreditApplicationResultDto creditApplicationResultDto = new CreditApplicationResultDto();

        creditApplicationResultDto.setCreditResultEnum( credit.getCreditResultEnum() );
        creditApplicationResultDto.setCreditLimit( credit.getCreditLimit() );

        return creditApplicationResultDto;
    }
}
