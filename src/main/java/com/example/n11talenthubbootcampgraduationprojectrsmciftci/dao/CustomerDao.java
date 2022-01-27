package com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {


    Optional<Customer> findCustomerByTurkishIdentityNumberAndDateOfBirth(String turkishIdentityNumber, LocalDate dateOfBirth);
    Optional<Customer> findCustomerByTurkishIdentityNumber(String turkishIdentityNumber);
}
