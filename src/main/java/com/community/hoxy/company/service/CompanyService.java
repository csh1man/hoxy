package com.community.hoxy.company.service;

import com.community.hoxy.company.entity.CompanyInfo;
import com.community.hoxy.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyInfo> getAllCompanies(){
        return companyRepository.findAll();
    }
}
