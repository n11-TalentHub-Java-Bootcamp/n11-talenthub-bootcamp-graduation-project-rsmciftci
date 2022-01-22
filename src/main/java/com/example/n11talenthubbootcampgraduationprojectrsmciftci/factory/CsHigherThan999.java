package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CsHigherThan999 implements Credit{

    int creditScore;
    BigDecimal monthlySalary;
    BigDecimal creditLimit;
    BigDecimal pledgeValue;

    public CsHigherThan999(  int creditScore, BigDecimal monthlySalary, BigDecimal creditLimit, BigDecimal pledgeValue) {

        this.creditScore = creditScore;
        this.monthlySalary = monthlySalary;
        this.creditLimit = monthlySalary.multiply(BigDecimal.valueOf(4)).add(pledgeValue.multiply(BigDecimal.valueOf(0.5))) // TODO: kredi limit çarpanı 4/2den geliyor
                .setScale(2, RoundingMode.HALF_EVEN);;
        this.pledgeValue = pledgeValue;
    }



    @Override
    public int getCreditScore() {
        return creditScore;
    }

    @Override
    public BigDecimal getMonthlySalary() {
        return monthlySalary;
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
                ", creditScore=" + creditScore +
                ", monthlySalary=" + monthlySalary +
                ", creditLimit=" + creditLimit +
                ", pledgeValue=" + pledgeValue +
                '}';
    }
}
