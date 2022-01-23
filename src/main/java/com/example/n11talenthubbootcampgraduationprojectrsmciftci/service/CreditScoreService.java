package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.exception.TurkishIdentityNumberNot11CharactersException;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Service
public class CreditScoreService {

    public CreditResultEnum getCreditScoreEnum(String turkishIdentityNumber){

        if(turkishIdentityNumber.length() != 11){
            throw new TurkishIdentityNumberNot11CharactersException("Turkish Identity Number Must Be Eleven Characters!");
        }

        Integer lastThreeDigitsOfTurkishIdentityNumber = Integer.valueOf(turkishIdentityNumber.substring(8,11));
        int creditScore = lastThreeDigitsOfTurkishIdentityNumber + 100;

        if(creditScore < 500){

            return CreditResultEnum.REJECTED;
        }else{

            return CreditResultEnum.APPROVED;
        }
    }

    public int getCreditScore(String turkishIdentityNumber){

        if(turkishIdentityNumber.length() != 11){
            throw new TurkishIdentityNumberNot11CharactersException("Turkish Identity Number Must Be Eleven Characters!");
        }

        Integer lastThreeDigitsOfTurkishIdentityNumber = Integer.valueOf(turkishIdentityNumber.substring(8,11));
        int creditScore = lastThreeDigitsOfTurkishIdentityNumber + 100;

        return creditScore;
    }

}
