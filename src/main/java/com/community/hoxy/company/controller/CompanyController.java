package com.community.hoxy.company.controller;

import com.community.hoxy.company.entity.CompanyInfo;
import com.community.hoxy.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 관리자페이지에서 회사를 추가할 때 사용하는 함수
     */
    @PostMapping(value="/company/insert-new")
    public ResponseEntity<?> insertCompanyInfo(@RequestBody CompanyInfo companyInfo){
        try{
            CompanyInfo newCompany = companyService.insertNewCompany(companyInfo);
            return ResponseEntity.ok(newCompany);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error Message :" + e.getMessage());
        }
    }
}
