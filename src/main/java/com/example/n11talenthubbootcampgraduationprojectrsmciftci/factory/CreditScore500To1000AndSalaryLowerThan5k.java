package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditScore500To1000AndSalaryLowerThan5k implements CreditProducedInFactory {

    int creditScore;
    CreditResultEnum creditResultEnum;
    Customer customer;
    BigDecimal creditLimit;
    BigDecimal pledgeValue;

    public CreditScore500To1000AndSalaryLowerThan5k(int creditScore, CreditResultEnum creditResultEnum, Customer customer , BigDecimal pledgeValue) {

        this.creditScore = creditScore;
        this.creditResultEnum = creditResultEnum;
        this.customer = customer;
        this.creditLimit = BigDecimal.valueOf(10000).add(pledgeValue.multiply(BigDecimal.valueOf(0.1))).setScale(2, RoundingMode.HALF_EVEN);;
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
        return "CS500To1000AndSalaryLowerThan5k{" +
                "creditScore=" + creditScore +
                ", creditResultEnum=" + creditResultEnum +
                ", customer=" + customer +
                ", creditLimit=" + creditLimit +
                ", pledgeValue=" + pledgeValue +
                '}';
    }
}
