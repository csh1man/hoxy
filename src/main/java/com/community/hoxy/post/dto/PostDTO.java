package com.community.hoxy.post.dto;

public class PostDTO {
    private String field;
    private String writer;
    private String title;
    private String content;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
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
}
