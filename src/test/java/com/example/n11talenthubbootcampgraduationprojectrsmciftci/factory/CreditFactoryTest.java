package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CreditDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CustomerDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.datasource.CreditFactoryDataSource;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditScoreService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CreditService;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.service.CustomerDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;
class CreditFactoryTest {



    @Test
    void getCreditIfCreditScoreLowerThan500() {

        Customer customer = CustomerDataProvider.getCustomerCreditScoreLowerThan500();
        int creditScore = 308 + 100; // creditScore = last3DigitsOfTurkishIdentityNumber + 100
        BigDecimal pledgeValue = BigDecimal.valueOf(50000);


        CreditProducedInFactory creditProducedInFactory =
                CreditFactory.getCredit(creditScore, CreditResultEnum.REJECTED,customer, pledgeValue);

        assertEquals(CreditResultEnum.REJECTED,creditProducedInFactory.getCreditResultEnum());
        assertEquals(BigDecimal.ZERO,creditProducedInFactory.getCreditLimit());
    }

    @Test
    void getCreditIfCreditScoreHigherThan999() {

        Customer customer = CustomerDataProvider.getCustomerCreditScoreHigherThan999();
        int creditScore = 992 + 100; // creditScore = last3DigitsOfTurkishIdentityNumber + 100
        BigDecimal pledgeValue = BigDecimal.valueOf(50000);

        BigDecimal expectedCreditLimit = customer.getMonthlySalary().multiply(BigDecimal.valueOf(4))
                .add(pledgeValue.multiply(BigDecimal.valueOf(0.5))).setScale(2, RoundingMode.HALF_EVEN);

        CreditProducedInFactory creditProducedInFactory =
                CreditFactory.getCredit(creditScore, CreditResultEnum.APPROVED,customer, pledgeValue);

        assertEquals(CreditResultEnum.APPROVED,creditProducedInFactory.getCreditResultEnum());
        assertEquals(expectedCreditLimit,creditProducedInFactory.getCreditLimit());
    }



    @Test
    void CreditScore500To1000AndSalaryLowerThan5k() {

        Customer customer = CustomerDataProvider.CreditScore500To1000AndSalaryLowerThan5k();
        int creditScore = 458 + 100; // creditScore = last3DigitsOfTurkishIdentityNumber + 100
        BigDecimal pledgeValue = BigDecimal.valueOf(50000);

        BigDecimal expectedCreditLimit = BigDecimal.valueOf(10000)
                .add(pledgeValue.multiply(BigDecimal.valueOf(0.1)))
                .setScale(2, RoundingMode.HALF_EVEN);

        CreditProducedInFactory creditProducedInFactory =
                CreditFactory.getCredit(creditScore, CreditResultEnum.APPROVED,customer, pledgeValue);

        assertEquals(CreditResultEnum.APPROVED,creditProducedInFactory.getCreditResultEnum());
        assertEquals(expectedCreditLimit,creditProducedInFactory.getCreditLimit());
    }

    @Test
    void CreditScore500To1000AndSalary5kTo10k() {

        Customer customer = CustomerDataProvider.CreditScore500To1000AndSalary5kTo10k();
        int creditScore = 458 + 100; // creditScore = last3DigitsOfTurkishIdentityNumber + 100
        BigDecimal pledgeValue = BigDecimal.valueOf(50000);

        BigDecimal expectedCreditLimit = BigDecimal.valueOf(20000)
                .add(pledgeValue.multiply(BigDecimal.valueOf(0.2)))
                .setScale(2, RoundingMode.HALF_EVEN);

        CreditProducedInFactory creditProducedInFactory =
                CreditFactory.getCredit(creditScore, CreditResultEnum.APPROVED,customer, pledgeValue);

        assertEquals(CreditResultEnum.APPROVED,creditProducedInFactory.getCreditResultEnum());
        assertEquals(expectedCreditLimit,creditProducedInFactory.getCreditLimit());
    }

    @Test
    void CreditScore500To1000AndSalaryHigherThan9999() {

        Customer customer = CustomerDataProvider.CreditScore500To1000AndSalaryHigherThan9999();
        int creditScore = 458 + 100; // creditScore = last3DigitsOfTurkishIdentityNumber + 100
        BigDecimal pledgeValue = BigDecimal.valueOf(50000);

        BigDecimal expectedCreditLimit = customer.getMonthlySalary()
                .multiply(BigDecimal.valueOf(4))
                .multiply(BigDecimal.valueOf(0.5))
                .add(pledgeValue.multiply(BigDecimal.valueOf(0.25)))
                .setScale(2, RoundingMode.HALF_EVEN);

        CreditProducedInFactory creditProducedInFactory =
                CreditFactory.getCredit(creditScore, CreditResultEnum.APPROVED,customer, pledgeValue);

        assertEquals(CreditResultEnum.APPROVED,creditProducedInFactory.getCreditResultEnum());
        assertEquals(expectedCreditLimit,creditProducedInFactory.getCreditLimit());
    }



}