package com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.validation.TurkishIdentityNumber;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class CustomerSavingDto {
    @Null
    private Long id;
    @TurkishIdentityNumber
    private String turkishIdentityNumber;
    @NotNull
    private String name;
    private String middleName;
    @NotNull
    private String surname;
    @NotNull
    @Pattern(regexp = "^\\d+$",message = "Phone number cannot include non-digit characters!")
    @Size(min = 11,max = 11, message = " Phone number must be eleven or ten digits!")
    private String phoneNumber;
    @Email
    @NotNull
    private String email;
    @Past
    @NotNull
    private LocalDate dateOfBirth;
    @DecimalMin(value = "0.0")
    @Digits(integer = 19,fraction = 2)
    @NotNull
    private BigDecimal monthlySalary;
}
