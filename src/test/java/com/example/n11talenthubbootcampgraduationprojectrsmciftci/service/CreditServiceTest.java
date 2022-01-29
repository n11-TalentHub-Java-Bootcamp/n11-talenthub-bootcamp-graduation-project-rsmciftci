package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter.CreditMapper;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter.CustomerMapper;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CreditDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CustomerDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationResultDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CustomerSavingDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Credit;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory.CreditFactory;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory.CreditProducedInFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class CreditServiceTest {
    @Mock
    private CreditDao creditDao;
    @Mock
    private CustomerDao customerDao;
    @Mock
    private CreditScoreService creditScoreService;

    @InjectMocks
    private CreditService creditService;


    @Test
    void shouldSaveCredit() {

         CreditApplicationDto creditApplicationDto = CreditDataProvider.getCreditApplicationDto();
         Customer customer = CustomerDataProvider.getCustomer();
         Optional<Customer> optionalCustomer = Optional.of(customer);

         lenient().when(customerDao.findCustomerByTurkishIdentityNumber(creditApplicationDto.getTurkishIdentityNumber())).thenReturn(optionalCustomer);
         assertTrue(optionalCustomer.isPresent());
         assertTrue((creditApplicationDto.getMonthlySalary().compareTo(customer.getMonthlySalary())) == 0);

         int creditScore = creditScoreService.getCreditScore(customer.getTurkishIdentityNumber());
         CreditResultEnum creditResultEnum = creditScoreService.getCreditScoreEnum(customer.getTurkishIdentityNumber());
         BigDecimal pledgeValue = creditApplicationDto.getPledgeValue();

         CreditProducedInFactory creditProducedInFactory = CreditFactory.getCredit(creditScore,creditResultEnum,customer,pledgeValue);
         Credit credit = CreditMapper.INSTANCE.convertCreditProducedFactoryToCredit(creditProducedInFactory);
         when(creditDao.save(ArgumentMatchers.any(Credit.class))).thenReturn(credit);

        CreditApplicationResultDto expected = new CreditApplicationResultDto();
        expected.setCreditLimit(credit.getCreditLimit());
        expected.setCreditResultEnum(credit.getCreditResultEnum());

        ResponseEntity expectedResponseEntity = ResponseEntity.ok(expected);
        ResponseEntity result = creditService.saveCredit(creditApplicationDto);

        String message = "TEST MESSAGE.\n"+"CREDIT "+credit.getCreditResultEnum()+".\nCredit Limit is "+ credit.getCreditLimit()+" TL.";
        //smsService.sendSms(message,customer.getPhoneNumber().substring(1));

        assertEquals(expectedResponseEntity, result);
    }

    @Test
    void shouldNotSaveCreditIfCustomerNotFound() {
        CreditApplicationDto creditApplicationDto = CreditDataProvider.getCreditApplicationDto();
        Optional<Customer> optionalCustomer = Optional.ofNullable(null);

        lenient().when(customerDao.findCustomerByTurkishIdentityNumber(creditApplicationDto.getTurkishIdentityNumber())).thenReturn(optionalCustomer);
        assertFalse(optionalCustomer.isPresent());

        ResponseEntity expected = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
        ResponseEntity result = creditService.saveCredit(creditApplicationDto);
        assertEquals(expected,result);

    }

    @Test
    void shouldNotSaveCreditIfSalariesNotMatch() {
        CreditApplicationDto creditApplicationDto = CreditDataProvider.getCreditApplicationDto();
        Customer customer = CustomerDataProvider.getCustomer();
        Optional<Customer> optionalCustomer = Optional.of(customer);

        lenient().when(customerDao.findCustomerByTurkishIdentityNumber(creditApplicationDto.getTurkishIdentityNumber())).thenReturn(optionalCustomer);
        assertTrue(optionalCustomer.isPresent());

        creditApplicationDto.setMonthlySalary(BigDecimal.valueOf(5000));
        customer.setMonthlySalary(BigDecimal.valueOf(6000));
        assertFalse((creditApplicationDto.getMonthlySalary().compareTo(customer.getMonthlySalary())) == 0);


        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> creditService.saveCredit(creditApplicationDto)  );

        assertTrue(thrown.getMessage().contains("Salary didn't match with salary value in database."));




    }



    @Test
    void shouldFindCreditApplication() {

        Credit credit = CreditDataProvider.getCredit();
        Optional<Credit> optionalCredit = Optional.of(credit);
        when(creditDao.findCreditApplication("41009520922", LocalDate.parse("1993-05-03"))).thenReturn(optionalCredit);
        assertTrue(optionalCredit.isPresent());

        CreditApplicationResultDto creditApplicationResultDto = CreditDataProvider.getCreditApplicationResultDto();
        ResponseEntity expected = ResponseEntity.ok(creditApplicationResultDto);

        ResponseEntity result = creditService.findCreditApplication("41009520922","1993-05-03");

        assertEquals(expected, result);


    }

    @Test
    void shouldNotFindCreditApplicationIfDateOfBirthAndTurkishIdentityNumberNotMatchOrCreditApplicationIsNotExist() {

        Optional<Credit> optionalCredit = Optional.ofNullable(null);
        when(creditDao.findCreditApplication("41009520922", LocalDate.parse("1993-05-03"))).thenReturn(optionalCredit);
        assertFalse(optionalCredit.isPresent());


        ResponseEntity expected =  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turkish identity number and date of birth didn't match!" +
                " Or Credit application hasn't been found!");

        ResponseEntity result = creditService.findCreditApplication("41009520922","1993-05-03");

        assertEquals(expected, result);

    }
}