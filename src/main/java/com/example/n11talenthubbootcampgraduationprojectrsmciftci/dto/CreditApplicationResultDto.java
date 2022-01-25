package com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CreditApplicationResultDto {
    @NotNull
    CreditResultEnum creditResultEnum;
    @DecimalMin(value = "0.0")
    @Digits(integer = 10,fraction = 2)
    @NotNull
    BigDecimal creditLimit;
}
