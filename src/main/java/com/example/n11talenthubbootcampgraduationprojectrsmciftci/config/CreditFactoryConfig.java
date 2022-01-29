package com.example.n11talenthubbootcampgraduationprojectrsmciftci.config;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.datasource.CreditFactoryDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@PropertySource("classpath:credit.properties")
@Configuration
public class CreditFactoryConfig {

    CreditFactoryDataSource factoryDataSource(
            @Value("${limitForCreditScore500To1000AndSalaryLessThan5000}") BigDecimal limitForCreditScore500To1000AndSalaryLessThan5000,
            @Value("${multiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000}") BigDecimal multiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000 ,
            @Value("${limitForCreditScore500To1000AndSalary5kTo10k}") BigDecimal limitForCreditScore500To1000AndSalary5kTo10k,
            @Value("${multiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k}") BigDecimal multiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k,
            @Value("${creditMultiplier}") BigDecimal creditMultiplier,
            @Value("${multiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k}") BigDecimal multiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k,
            @Value("${multiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k}") BigDecimal multiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k,
            @Value("${multiplierOfPledgeForCreditScoreBiggerThan1k}") BigDecimal multiplierOfPledgeForCreditScoreBiggerThan1k

    ){
        CreditFactoryDataSource creditFactoryDataSource = new CreditFactoryDataSource();
        creditFactoryDataSource.setLimitForCreditScore500To1000AndSalaryLessThan5000(limitForCreditScore500To1000AndSalaryLessThan5000);
        creditFactoryDataSource.setMultiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000(multiplierOfPledgeForCreditScore500To1000AndSalaryLessThan5000);
        creditFactoryDataSource.setLimitForCreditScore500To1000AndSalary5kTo10k(limitForCreditScore500To1000AndSalary5kTo10k);
        creditFactoryDataSource.setMultiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k(multiplierOfPledgeForCreditScore500To1000AndSalary5kTo10k);
        creditFactoryDataSource.setCreditMultiplier(creditMultiplier);
        creditFactoryDataSource.setMultiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k(multiplierOfCreditMultiplierForCreditScore500To1000AndSalaryMoreThan10k);
        creditFactoryDataSource.setMultiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k(multiplierOfPledgeForCreditScore500To1000AndSalaryMoreThan10k);
        creditFactoryDataSource.setMultiplierOfPledgeForCreditScoreBiggerThan1k(multiplierOfPledgeForCreditScoreBiggerThan1k);



        return creditFactoryDataSource;
    }
}