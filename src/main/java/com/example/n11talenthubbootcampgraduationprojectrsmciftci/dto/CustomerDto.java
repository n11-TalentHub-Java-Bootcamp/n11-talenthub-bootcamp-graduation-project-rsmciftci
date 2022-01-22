package com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CustomerDto {

    private Long id;
    private String turkishIdentityNumber;
    private String name;
    private String middleName;
    private String surname;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private BigDecimal monthlySalary;

}
