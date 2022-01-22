package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;

public class CreditScoreLowerThan500 implements Credit{


    int creditScore;
    BigDecimal monthlySalary;
    BigDecimal creditLimit;
    BigDecimal pledgeValue;

    public CreditScoreLowerThan500(  int creditScore, BigDecimal monthlySalary, BigDecimal creditLimit, BigDecimal pledgeValue) {

        this.creditScore = creditScore;
        this.monthlySalary = monthlySalary;
        this.creditLimit = BigDecimal.ZERO;
        this.pledgeValue = pledgeValue;
    }




    @Override
    public int getCreditScore() {
        return 0;
    }

    @Override
    public BigDecimal getMonthlySalary() {
        return null;
    }

    @Override
    public BigDecimal getCreditLimit() {
        return null;
    }

    @Override
    public BigDecimal getPledgeValue() {
        return null;
    }

    @Override
    public String toString() {
        return "CreditScoreLowerThan500{" +
                ", getCreditScore=" + creditScore +
                ", getMonthlySalary=" + monthlySalary +
                ", getCreditLimit=" + creditLimit +
                ", getPledgeValue=" + pledgeValue +
                '}';
    }
}
