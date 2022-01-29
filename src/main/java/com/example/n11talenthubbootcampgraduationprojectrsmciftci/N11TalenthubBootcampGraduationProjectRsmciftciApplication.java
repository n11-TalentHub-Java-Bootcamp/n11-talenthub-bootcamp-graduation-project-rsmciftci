package com.example.n11talenthubbootcampgraduationprojectrsmciftci;


import com.example.n11talenthubbootcampgraduationprojectrsmciftci.datasource.CreditFactoryDataSource;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.datasource.SmsApiDataSource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@OpenAPIDefinition
public class N11TalenthubBootcampGraduationProjectRsmciftciApplication {



	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(N11TalenthubBootcampGraduationProjectRsmciftciApplication.class, args);


	}

}
