package com.example.n11talenthubbootcampgraduationprojectrsmciftci.service;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditScoreServiceTest {

    @InjectMocks
    private CreditScoreService creditScoreService;
    @Mock
    private CreditScoreService creditScoreServiceMock;

    @Test
    void getCreditScoreEnumApproved() {
        // creditScore = last3DigitsOfTurkishIdentityNumber+100 = 1022
        when(creditScoreServiceMock.getCreditScore("41009520922")).thenReturn(1022);
        assertTrue(creditScoreServiceMock.getCreditScore("41009520922") >= 500);
        CreditResultEnum expectedEnum = CreditResultEnum.APPROVED;
        CreditResultEnum resultEnum = creditScoreService.getCreditScoreEnum("41009520922");
        assertEquals(expectedEnum, resultEnum);
    }

    @Test
    void getCreditScoreEnumRejected() {
        // creditScore = last3DigitsOfTurkishIdentityNumber+100 = 112
        when(creditScoreServiceMock.getCreditScore("50888138012")).thenReturn(112);
        assertFalse(creditScoreServiceMock.getCreditScore("50888138012") >= 500);
        CreditResultEnum expectedEnum = CreditResultEnum.REJECTED;
        CreditResultEnum resultEnum = creditScoreService.getCreditScoreEnum("50888138012");
        assertEquals(expectedEnum, resultEnum);
    }

    @Test
    void getCreditScore() {
        // creditScore = last3DigitsOfTurkishIdentityNumber+100 = 112
        when(creditScoreServiceMock.getCreditScore("50888138012")).thenReturn(112);
        int expected = creditScoreServiceMock.getCreditScore("50888138012");
        int result = creditScoreService.getCreditScore("50888138012");
        assertEquals(expected, result);
    }
}