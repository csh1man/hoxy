package com.community.hoxy.user.entity;

import com.community.hoxy.user.dto.UserInsertDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_info")
public class UserInfo {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="pwd")
    private String pwd;
    @Column(name="nickname")
    private String nickName;
    @Column(name="company")
    private String company;
    @Column(name="mbti")
    private String mbti;
    @Column(name="reg_date")
    private Date regDate;
    @Column(name="mod_date")
    private Date modDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
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

    @PrePersist
    protected void prePersist(){
        if(this.regDate == null){
            this.regDate = new Date();
        }
    }

    @PreUpdate
    protected void preUpdate(){
        this.modDate = new Date();
    }

    public static UserInfo from(UserInsertDTO dto){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(dto.getId());
        userInfo.setPwd(dto.getPwd());
        userInfo.setNickName(dto.getNickname());
        userInfo.setCompany(dto.getCompany());
        userInfo.setMbti(dto.getMbti());

        return userInfo;
    }
}
