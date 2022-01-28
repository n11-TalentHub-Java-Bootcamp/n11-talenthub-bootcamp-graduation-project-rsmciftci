package com.example.n11talenthubbootcampgraduationprojectrsmciftci.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TurkishIdentityNumberValidatorTest {

    @InjectMocks
    private TurkishIdentityNumberValidator turkishIdentityNumberValidator;

    @Mock
    private ConstraintValidatorContext context;

    @Test
    void isValid() {

        boolean result = turkishIdentityNumberValidator.isValid("11915797336",context);
        assertEquals(true,result);

    }

    @Test
    void isIt11characters() {
        boolean result = turkishIdentityNumberValidator.isIt11characters("11111111111");
        assertEquals(true,result);
    }

    @Test
    void isAllDigit() {

        boolean result = turkishIdentityNumberValidator.isAllDigit("1234234");
        assertEquals(true,result);
    }
    @Test
    void isAnyNonDigit() {

        boolean result = turkishIdentityNumberValidator.isAllDigit("123s4234");
        assertEquals(false,result);
    }

    @Test
    void isUnitOfSumOfFirst10EqualTo11thNumber() {

        boolean result = turkishIdentityNumberValidator.isUnitOfSumOfFirst10EqualTo11thNumber("10000000001");
        assertEquals(true,result);
    }

    @Test
    void isUnitOfSumOf1st3rd5th7th9thTimes8EqualTo11thNumber() {
        //  (1+1+1+1+1)*5 = 40 --> unitOf(40) = 0
        boolean result = turkishIdentityNumberValidator.isUnitOfSumOf1st3rd5th7th9thTimes8EqualTo11thNumber("10101010100");
        assertEquals(true,result);
    }

    @Test
    void calculateSumOf1st3rd5th7th9thTimes7() {
        // (1+1+1+1+1)*7 = 35
        int result = turkishIdentityNumberValidator.calculateSumOf1st3rd5th7th9thTimes7("10101010100");
        assertEquals(35,result);
    }

    @Test
    void calculateSumOf2nd4th6th8thTimes9() {
        // (1+1+1+1)*9 = 36
        int result = turkishIdentityNumberValidator.calculateSumOf2nd4th6th8thTimes9("01010101000");
        assertEquals(36,result);
    }

    // Xx =  7 * sum(1st,3rd,5th,7th and 9th digits of turkishIdentityNumber)
    // Yy = 9 * sum(2nd, 4th, 6th and 8th digits of turkishIdentityNumber)
    // Zz = 10th digit of turkishIdentityNumber
    @Test
    void isZzEqualToSumOfXxAndYy() {
        boolean result = turkishIdentityNumberValidator.isZzEqualToSumOfXxAndYy("11915797336");
        assertEquals(true,result);
    }
}