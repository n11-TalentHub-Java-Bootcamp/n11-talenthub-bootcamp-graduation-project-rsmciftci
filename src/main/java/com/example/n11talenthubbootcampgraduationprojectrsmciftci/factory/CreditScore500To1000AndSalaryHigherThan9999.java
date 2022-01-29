package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditScore500To1000AndSalaryHigherThan9999  implements CreditProducedInFactory{
    /*
     * For this class,
     *  creditScore = [500,1000)
     *  salary >= 10k
     */


    int creditScore;
    CreditResultEnum creditResultEnum;
    Customer customer;
    BigDecimal creditLimit;
    BigDecimal pledgeValue;



    public CreditScore500To1000AndSalaryHigherThan9999(int creditScore, CreditResultEnum creditResultEnum, Customer customer , BigDecimal pledgeValue) {

        this.creditScore = creditScore;
        this.creditResultEnum = creditResultEnum;
        this.customer = customer;
        this.creditLimit = customer.getMonthlySalary().multiply(BigDecimal.valueOf(2))
                .add(pledgeValue.multiply(BigDecimal.valueOf(0.25))) // TODO: kredi limit çarpanı 4/2den geliyor
                .setScale(2,RoundingMode.HALF_EVEN);
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
        return "CS500To1000AndSalaryHigherThan9999{" +
                "creditScore=" + creditScore +
                ", creditResultEnum=" + creditResultEnum +
                ", customer=" + customer +
                ", creditLimit=" + creditLimit +
                ", pledgeValue=" + pledgeValue +
                '}';
    }
}
