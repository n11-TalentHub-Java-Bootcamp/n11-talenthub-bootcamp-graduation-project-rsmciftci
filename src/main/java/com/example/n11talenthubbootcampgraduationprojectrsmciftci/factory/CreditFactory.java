package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;

public class CreditFactory {
    public static Credit getCredit( int creditScore, BigDecimal monthlySalary, BigDecimal creditLimit, BigDecimal pledgeValue){
        Credit credit;
        if(creditScore < 500){
            credit = new CreditScoreLowerThan500(creditScore,monthlySalary,creditLimit,pledgeValue);
        }else if(creditScore >= 500 && creditScore < 1000){
            if(monthlySalary.compareTo(BigDecimal.valueOf(5000)) == -1){
                credit = new CS500To1000AndSalaryLowerThan5k(creditScore,monthlySalary,creditLimit,pledgeValue);
            }else if(monthlySalary.compareTo(BigDecimal.valueOf(10000)) == -1){
                credit = new CS500To1000AndSalary5kTo10k(creditScore,monthlySalary,creditLimit,pledgeValue);
            }else if(monthlySalary.compareTo(BigDecimal.valueOf(10000)) == 0 || monthlySalary.compareTo(BigDecimal.valueOf(10000)) == 1){
                credit = new CS500To1000AndSalaryHigherThan9999(creditScore,monthlySalary,creditLimit,pledgeValue);
            }else{
                throw new RuntimeException("Credit limit couldn't be produced at CreditFactory.");
            }
        }else if(creditScore > 1000){
            credit = new CsHigherThan999(creditScore,monthlySalary,creditLimit,pledgeValue);
        }else{
            throw new RuntimeException("Credit limit couldn't be produced at CreditFactory.");
        }

        return credit;
    }
}
