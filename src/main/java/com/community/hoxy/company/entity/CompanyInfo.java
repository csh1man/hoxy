package com.community.hoxy.company.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="company_info")
public class CompanyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private Long companyId;
    @Column(name="company_name")
    private String companyName;
    @Column(name="email_domain")
    private String emailDomain;
    @Column(name="reg_date")
    private Date regDate;
    @Column(name="mod_date")
    private Date modDate;
    @Column(name="activate")
    private boolean activate;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmailDomain() {
        return emailDomain;
    }

    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
}
