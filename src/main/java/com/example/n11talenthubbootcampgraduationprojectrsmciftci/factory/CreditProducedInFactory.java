package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;

import java.math.BigDecimal;

public interface CreditProducedInFactory {
 // TODO:properties file değerleri göm oradan çek
    // TODO : toStringlerde sadece kredi limiti olsa yeter, veya toStringlere gerek var mı?
    // TODO: üretilen kredi limiti değerleri her aralık için doğru mu?

    int getCreditScore();
    CreditResultEnum getCreditResultEnum();
    Customer getCustomer();
    BigDecimal getCreditLimit();
    BigDecimal getPledgeValue();

}
