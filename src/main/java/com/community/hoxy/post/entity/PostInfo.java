package com.community.hoxy.post.entity;

import com.community.hoxy.post.dto.PostInsertDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post_info")
public class PostInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private int postId;
    @Column(name="user_id")
    private String userId;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="view_count")
    private int viewCount;
    @Column(name="like_count")
    private int likeCount;
    @Column(name="comment_count")
    private int commentCount;
    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name="update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @PrePersist
    protected void prePersist(){
        if(this.createAt == null){
            this.createAt = new Date();
        }
    }

    @PreUpdate
    protected void preUpdate(){
        this.updateAt = new Date();
    }

    public static PostInfo from(PostInsertDTO postInsertDTO){
        PostInfo postInfo = new PostInfo();
        postInfo.setUserId(postInsertDTO.getUserId());
        postInfo.setTitle(postInsertDTO.getTitle());
        postInfo.setContent(postInsertDTO.getContent());

        return postInfo;
    }
}