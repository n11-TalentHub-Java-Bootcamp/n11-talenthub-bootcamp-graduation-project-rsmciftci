package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationResultDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Credit;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.validation.TurkishIdentityNumber;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    public static CreditApplicationDto getCreditApplicationDto() {
        CreditApplicationDto creditApplicationDto = new CreditApplicationDto();

        creditApplicationDto.setTurkishIdentityNumber("41009520922");
        creditApplicationDto.setName("Rasim");
        creditApplicationDto.setSurname("Ciftci");
        creditApplicationDto.setPhoneNumber("05413735686");
        creditApplicationDto.setEmail("rsmciftci@gmail.com");
        creditApplicationDto.setDateOfBirth(LocalDate.parse("1993-05-03"));
        creditApplicationDto.setMonthlySalary(BigDecimal.valueOf(5000));
        creditApplicationDto.setPledgeValue(BigDecimal.valueOf(50000));

        return creditApplicationDto;
    }
}
