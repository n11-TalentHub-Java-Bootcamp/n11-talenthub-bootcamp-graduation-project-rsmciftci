package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.converter.CreditMapper;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CreditDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao.CustomerDao;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationResultDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Credit;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
    void saveCredit() {

        //TODO: should write the test
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