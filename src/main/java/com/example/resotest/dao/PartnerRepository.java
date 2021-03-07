package com.example.resotest.dao;

import com.example.resotest.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
    @Query(value = "select partners.email from partners where id=?1", nativeQuery = true)
    String findEmailById(Long id);
}
