package com.community.hoxy.company.controller;

import com.community.hoxy.company.entity.CompanyInfo;
import com.community.hoxy.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 혹시 프로젝트에 등록된 회사에 대한 정보와 관련한 서비스로직을 처리하는 컨트롤러
 */
@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    /**
     * 혹시 프로젝트에 등록된 모든 회사에 대한 목록을 반환
     */
    @GetMapping(value="/company/list-all")
    public ResponseEntity<List<CompanyInfo>> getCompanyAll(){
        List<CompanyInfo> companyInfos = companyService.getAllCompanies();
        return ResponseEntity.ok(companyInfos);
    }

}
