package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CS500To1000AndSalary5kTo10k  implements Credit{
    /*
     * For this class,
     *  creditScore = [500,1000)
     *  salary = [5000,10000)
     */


    int creditScore;
    BigDecimal monthlySalary;
    BigDecimal creditLimit;
    BigDecimal pledgeValue;

    public CS500To1000AndSalary5kTo10k(  int creditScore, BigDecimal monthlySalary, BigDecimal creditLimit, BigDecimal pledgeValue) {

        this.creditScore = creditScore;
        this.monthlySalary = monthlySalary;
        this.creditLimit = BigDecimal.valueOf(20000).add(pledgeValue.multiply(BigDecimal.valueOf(0.2))).setScale(2, RoundingMode.HALF_EVEN);
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
        return "CS500To1000AndSalary5kTo10k{" +
                ", creditScore=" + creditScore +
                ", monthlySalary=" + monthlySalary +
                ", creditLimit=" + creditLimit +
                ", pledgeValue=" + pledgeValue +
                '}';
    }
}
