package com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name ="CUSTOMER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true,nullable = false,length = 11)
    private String turkishIdentityNumber; // TODO:validation

    @Column(nullable = false)
    private String name;

    private String middleName;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false,length = 11)
    private String phoneNumber;

    private String email;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false, scale = 2) // TODO:scale 2
    private BigDecimal monthlySalary; // TODO: valitadion?


}