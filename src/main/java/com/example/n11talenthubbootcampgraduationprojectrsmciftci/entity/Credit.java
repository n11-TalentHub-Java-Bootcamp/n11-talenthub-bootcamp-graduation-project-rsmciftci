package com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.enums.CreditResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name ="CREDIT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit{

    @Id
    @SequenceGenerator(name = "Credit", sequenceName = "CREDIT_ID_SEQ")
    @GeneratedValue(generator = "Credit")
    private Long id;


    @Column(scale = 2)// TODO:scale 2
    private BigDecimal pledgeValue; 
    @Column(scale = 2)
    private BigDecimal creditLimit;
    @Enumerated(EnumType.STRING)
    private CreditResultEnum creditResultEnum;
    private int creditScore;
    @OneToOne
    @JoinColumn(name="turkish_identity_number",referencedColumnName = "turkishIdentityNumber",unique = true)
    private Customer customer;


}
