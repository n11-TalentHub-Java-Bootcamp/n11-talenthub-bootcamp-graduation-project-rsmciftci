package com.example.n11talenthubbootcampgraduationprojectrsmciftci.dao;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditDao extends JpaRepository<Credit,Long> {

}
