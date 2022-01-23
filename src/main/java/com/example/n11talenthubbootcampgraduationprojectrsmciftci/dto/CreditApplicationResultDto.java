package com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditApplicationResultDto {
    CreditResultEnum creditResultEnum;
    BigDecimal creditLimit;
}
