package com.example.n11talenthubbootcampgraduationprojectrsmciftci.factory;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.datasource.CreditFactoryDataSource;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
