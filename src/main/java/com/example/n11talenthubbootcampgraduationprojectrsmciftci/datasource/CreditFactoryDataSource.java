package com.example.n11talenthubbootcampgraduationprojectrsmciftci.datasource;

import java.math.BigDecimal;

public class CreditFactoryDataSource {

    private BigDecimal limitForCreditScore500To1000AndSalaryLessThan5000;
    private BigDecimal multiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000;

    private BigDecimal limitForCreditScore500To1000AndSalary5kTo10k;
    private BigDecimal multiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k;

    private BigDecimal creditMultiplier;
    private BigDecimal multiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k;
    private BigDecimal multiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k;

    private BigDecimal multiplierOfPledgeForCreditScoreBiggerThan1k;

    public BigDecimal getLimitForCreditScore500To1000AndSalaryLessThan5000() {
        return limitForCreditScore500To1000AndSalaryLessThan5000;
    }

    public void setLimitForCreditScore500To1000AndSalaryLessThan5000(BigDecimal limitForCreditScore500To1000AndSalaryLessThan5000) {
        this.limitForCreditScore500To1000AndSalaryLessThan5000 = limitForCreditScore500To1000AndSalaryLessThan5000;
    }

    public BigDecimal getMultiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000() {
        return multiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000;
    }

    public void setMultiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000(BigDecimal multiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000) {
        this.multiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000 = multiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000;
    }

    public BigDecimal getLimitForCreditScore500To1000AndSalary5kTo10k() {
        return limitForCreditScore500To1000AndSalary5kTo10k;
    }

    public void setLimitForCreditScore500To1000AndSalary5kTo10k(BigDecimal limitForCreditScore500To1000AndSalary5kTo10k) {
        this.limitForCreditScore500To1000AndSalary5kTo10k = limitForCreditScore500To1000AndSalary5kTo10k;
    }

    public BigDecimal getMultiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k() {
        return multiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k;
    }

    public void setMultiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k(BigDecimal multiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k) {
        this.multiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k = multiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k;
    }

    public BigDecimal getCreditMultiplier() {
        return creditMultiplier;
    }

    public void setCreditMultiplier(BigDecimal creditMultiplier) {
        this.creditMultiplier = creditMultiplier;
    }

    public BigDecimal getMultiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k() {
        return multiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k;
    }

    public void setMultiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k(BigDecimal multiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k) {
        this.multiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k = multiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k;
    }

    public BigDecimal getMultiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k() {
        return multiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k;
    }

    public void setMultiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k(BigDecimal multiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k) {
        this.multiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k = multiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k;
    }

    public BigDecimal getMultiplierOfPledgeForCreditScoreBiggerThan1k() {
        return multiplierOfPledgeForCreditScoreBiggerThan1k;
    }

    public void setMultiplierOfPledgeForCreditScoreBiggerThan1k(BigDecimal multiplierOfPledgeForCreditScoreBiggerThan1k) {
        this.multiplierOfPledgeForCreditScoreBiggerThan1k = multiplierOfPledgeForCreditScoreBiggerThan1k;
    }
}
