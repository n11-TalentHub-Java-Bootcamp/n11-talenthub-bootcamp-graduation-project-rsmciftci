package com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class CreditApplicationDto {

    private String turkishIdentityNumber;
    private String name;
    private String middleName;
    private String surname;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private BigDecimal monthlySalary;
    private BigDecimal pledgeValue;

}
