package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;

public interface Credit {
 // TODO:properties file değerleri göm oradan çek
    // TODO : toStringlerde sadece kredi limiti olsa yeter

    int getCreditScore();
    BigDecimal getMonthlySalary();
    BigDecimal getCreditLimit();
    BigDecimal getPledgeValue();

}
