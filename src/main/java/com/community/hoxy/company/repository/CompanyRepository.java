package com.community.hoxy.company.repository;

import com.community.hoxy.company.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyInfo, Long> {
}
