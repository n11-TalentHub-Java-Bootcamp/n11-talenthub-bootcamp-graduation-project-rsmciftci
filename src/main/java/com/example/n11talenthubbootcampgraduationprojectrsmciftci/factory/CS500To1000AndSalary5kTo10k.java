package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CS500To1000AndSalary5kTo10k  implements CreditProducedInFactory {
    /*
     * For this class,
     *  creditScore = [500,1000)
     *  salary = [5000,10000)
     */


    int creditScore;
    CreditResultEnum creditResultEnum;
    Customer customer;
    BigDecimal creditLimit;
    BigDecimal pledgeValue;

    public CS500To1000AndSalary5kTo10k(  int creditScore,CreditResultEnum creditResultEnum, Customer customer , BigDecimal pledgeValue) {
        this.creditResultEnum = creditResultEnum;
        this.creditScore = creditScore;
        this.customer = customer;
        this.creditLimit = BigDecimal.valueOf(20000).add(pledgeValue.multiply(BigDecimal.valueOf(0.2))).setScale(2, RoundingMode.HALF_EVEN);
        this.pledgeValue = pledgeValue;
    }


    @Override
    public CreditResultEnum getCreditResultEnum() {
        return creditResultEnum;
    }

    @Override
    public int getCreditScore() {
        return creditScore;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    @Override
    public BigDecimal getPledgeValue() {
        return pledgeValue;
    }

    @Override
    public String toString() {
        return "CS500To1000AndSalary5kTo10k{" +
                "creditScore=" + creditScore +
                ", creditResultEnum=" + creditResultEnum +
                ", customer=" + customer +
                ", creditLimit=" + creditLimit +
                ", pledgeValue=" + pledgeValue +
                '}';
    }
}
