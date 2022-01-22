package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CS500To1000AndSalaryHigherThan9999 implements Credit{
    /*
     * For this class,
     *  creditScore = [500,1000)
     *  salary >= 10k
     */


    int creditScore;
    BigDecimal monthlySalary;
    BigDecimal creditLimit;
    BigDecimal pledgeValue;


    public CS500To1000AndSalaryHigherThan9999(  int creditScore, BigDecimal monthlySalary, BigDecimal creditLimit, BigDecimal pledgeValue) {

        this.creditScore = creditScore;
        this.monthlySalary = monthlySalary;
        this.creditLimit = monthlySalary.multiply(BigDecimal.valueOf(2)).add(pledgeValue.multiply(BigDecimal.valueOf(0.25))) // TODO: kredi limit çarpanı 4/2den geliyor
                .setScale(2,RoundingMode.HALF_EVEN);
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
        return "CS500To100AndSalaryHigherThan9999{" +
                ", creditScore=" + creditScore +
                ", monthlySalary=" + monthlySalary +
                ", creditLimit=" + creditLimit +
                ", pledgeValue=" + pledgeValue +
                '}';
    }
}
