package com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class CreditApplicationDto {
    @Size(min = 11,max = 11)
    private String turkishIdentityNumber;
    @NotNull
    private String name;
    private String middleName;
    @NotNull
    @Size(min = 1)
    private String surname;
    @Length(min = 11,max= 11)
    private String phoneNumber;
    @Email
    @NotNull
    private String email;
    @Past
    private LocalDate dateOfBirth;
    @DecimalMin(value = "0.0")
    @Digits(integer = 10,fraction = 2)
    @NotNull
    private BigDecimal monthlySalary;
    @DecimalMin(value = "0.0")
    @Digits(integer = 10,fraction = 2)
    private BigDecimal pledgeValue;

}
