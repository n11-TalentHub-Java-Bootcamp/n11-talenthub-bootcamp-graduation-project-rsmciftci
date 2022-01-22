package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreService {

    CreditResultEnum getCreditScoreResult(String turkishIdentityNumber){

        Integer lastThreeDigitsOfTurkishIdentityNumber = Integer.valueOf(turkishIdentityNumber.substring(8,10));
        Integer creditScore = lastThreeDigitsOfTurkishIdentityNumber + 100;

        if(creditScore < 500){
            return CreditResultEnum.REJECTED;
        }else{
            return CreditResultEnum.APPROVED;
        }
    }

}
