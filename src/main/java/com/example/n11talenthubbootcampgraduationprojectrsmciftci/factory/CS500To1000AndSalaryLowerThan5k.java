package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CS500To1000AndSalaryLowerThan5k implements Credit{

    int creditScore;
    BigDecimal monthlySalary;
    BigDecimal creditLimit;
    BigDecimal pledgeValue;

    public CS500To1000AndSalaryLowerThan5k(  int creditScore, BigDecimal monthlySalary, BigDecimal creditLimit, BigDecimal pledgeValue) {

        this.creditScore = creditScore;
        this.monthlySalary = monthlySalary;
        this.creditLimit = BigDecimal.valueOf(10000).add(pledgeValue.multiply(BigDecimal.valueOf(0.1))).setScale(2, RoundingMode.HALF_EVEN);;
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
        return "CS500To1000AndSalaryLowerThan5k{" +
                ", creditScore=" + creditScore +
                ", monthlySalary=" + monthlySalary +
                ", creditLimit=" + creditLimit +
                ", pledgeValue=" + pledgeValue +
                '}';
    }
}
