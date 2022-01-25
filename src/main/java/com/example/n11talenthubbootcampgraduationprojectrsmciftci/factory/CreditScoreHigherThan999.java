package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditScoreHigherThan999 implements CreditProducedInFactory {

    int creditScore;
    CreditResultEnum creditResultEnum;
    Customer customer;
    BigDecimal creditLimit;
    BigDecimal pledgeValue;

    public CreditScoreHigherThan999(int creditScore, CreditResultEnum creditResultEnum, Customer customer , BigDecimal pledgeValue) {

        this.creditScore = creditScore;
        this.creditResultEnum = creditResultEnum;
        this.customer = customer;
        this.creditLimit = customer.getMonthlySalary().multiply(BigDecimal.valueOf(4)).add(pledgeValue.multiply(BigDecimal.valueOf(0.5))) // TODO: kredi limit çarpanı 4/2den geliyor
                .setScale(2, RoundingMode.HALF_EVEN);;
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
        return "CsHigherThan999{" +
                "creditScore=" + creditScore +
                ", creditResultEnum=" + creditResultEnum +
                ", customer=" + customer +
                ", creditLimit=" + creditLimit +
                ", pledgeValue=" + pledgeValue +
                '}';
    }
}
