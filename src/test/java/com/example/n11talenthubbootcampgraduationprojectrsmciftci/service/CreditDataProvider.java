package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationResultDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Credit;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;

public class CreditDataProvider {

    public static Credit getCredit() {
        Credit credit = new Credit();

        credit.setCreditLimit(BigDecimal.valueOf(50000));
        credit.setCustomer(CustomerDataProvider.getCustomer());
        credit.setCreditScore(1022);
        credit.setPledgeValue(BigDecimal.valueOf(50000));
        credit.setCreditResultEnum(CreditResultEnum.APPROVED);
        credit.setId(1L);

        return credit;
    }

    public static CreditApplicationResultDto getCreditApplicationResultDto() {
        CreditApplicationResultDto creditApplicationResultDto = new CreditApplicationResultDto();
        creditApplicationResultDto.setCreditResultEnum(CreditResultEnum.APPROVED);
        creditApplicationResultDto.setCreditLimit(BigDecimal.valueOf(50000));
        return creditApplicationResultDto;
    }
}
