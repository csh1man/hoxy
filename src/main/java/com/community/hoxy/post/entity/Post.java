package com.community.hoxy.post.entity;

import com.community.hoxy.post.dto.PostDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long contentId;
    @Column(name="field")
    private String field;
    @Column(name="writer")
    private String writer;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="reg_date")
    private Date regDate;
    @Column(name = "mod_date")
    private Date modDate;

    public Post(PostDTO dto){
        this.field   = dto.getField();
        this.writer  = dto.getWriter();
        this.title   = dto.getTitle();
        this.content = dto.getContent();
        this.regDate = new Date();
        this.modDate = new Date();
    }
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
