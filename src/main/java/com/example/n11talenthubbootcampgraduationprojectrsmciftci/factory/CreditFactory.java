package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.datasource.CreditFactoryDataSource;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.math.BigDecimal;
public class CreditFactory {





    public static CreditProducedInFactory getCredit(int creditScore, CreditResultEnum creditResultEnum, Customer customer, BigDecimal pledgeValue){




        CreditProducedInFactory creditProducedInFactory;
        BigDecimal monthlySalary = customer.getMonthlySalary();
        if(creditScore < 500){
            creditProducedInFactory = new CreditScoreLowerThan500(creditScore, creditResultEnum,customer,pledgeValue);
        }else if(creditScore >= 500 && creditScore < 1000){
            if(monthlySalary.compareTo(BigDecimal.valueOf(5000)) == -1){
                creditProducedInFactory = new CreditScore500To1000AndSalaryLowerThan5k(creditScore, creditResultEnum,customer,pledgeValue);
            }else if(monthlySalary.compareTo(BigDecimal.valueOf(10000)) == -1){
                creditProducedInFactory = new CreditScore500To1000AndSalary5kTo10k(creditScore, creditResultEnum,customer,pledgeValue);
            }else if(monthlySalary.compareTo(BigDecimal.valueOf(10000)) == 0 || monthlySalary.compareTo(BigDecimal.valueOf(10000)) == 1){
                creditProducedInFactory = new CreditScore500To1000AndSalaryHigherThan9999(creditScore, creditResultEnum,customer,pledgeValue);
            }else{
                throw new RuntimeException("Credit limit couldn't be produced at CreditFactory.");
            }
        }else if(creditScore >= 1000){
            creditProducedInFactory = new CreditScoreHigherThan999(creditScore, creditResultEnum,customer,pledgeValue);
        }else{
            throw new RuntimeException("Credit limit couldn't be produced at CreditFactory.");
        }

        return creditProducedInFactory;
    }
}
