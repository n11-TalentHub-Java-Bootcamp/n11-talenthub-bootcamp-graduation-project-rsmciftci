package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;


import java.math.BigDecimal;
public class CreditScoreLowerThan500 implements CreditProducedInFactory {


    int creditScore;
    CreditResultEnum creditResultEnum;
    Customer customer;
    BigDecimal creditLimit;
    BigDecimal pledgeValue;

    public CreditScoreLowerThan500(int creditScore, CreditResultEnum creditResultEnum, Customer customer, BigDecimal pledgeValue) {
        this.creditResultEnum = creditResultEnum;
        this.creditScore = creditScore;
        this.customer = customer;
        this.creditLimit = BigDecimal.ZERO;
        this.pledgeValue = pledgeValue;
    }

    @Override
    public int getCreditScore() {
        return creditScore;
    }

    @Override
    public CreditResultEnum getCreditResultEnum() {
        return creditResultEnum;
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
        return "CreditScoreLowerThan500{" +
                "creditScore=" + creditScore +
                ", creditResultEnum=" + creditResultEnum +
                ", customer=" + customer +
                ", creditLimit=" + creditLimit +
                ", pledgeValue=" + pledgeValue +
                '}';
    }
}
