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
        List<CompanyInfo> companyInfos = companyRepository.findAll();
        for(CompanyInfo companyInfo : companyInfos){
            if(companyInfo.getEmailDomain().contains("@")){
                companyInfo.setEmailDomain(companyInfo.getEmailDomain().replace("@",""));
            }
        }

        return companyInfos;
    }

    /**
     * 회사 정보 데이터 삽입
     * @param companyInfo 회사정보
     */
    public CompanyInfo insertNewCompany(CompanyInfo companyInfo){
        return companyRepository.save(companyInfo);
    }
}
