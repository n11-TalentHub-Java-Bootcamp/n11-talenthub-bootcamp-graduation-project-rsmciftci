package com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.dto.CreditApplicationResultDto;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface CreditDao extends JpaRepository<Credit,Long> {

    @Query("select credit FROM Credit credit " +
            " inner join Customer customer on credit.customer.turkishIdentityNumber = customer.turkishIdentityNumber " +
            " WHERE credit.customer.turkishIdentityNumber = :turkishIdentityNumber " +
            " AND customer.dateOfBirth = :dateOfBirth")
    Optional<Credit> findCreditApplication(String turkishIdentityNumber, LocalDate dateOfBirth);

}
