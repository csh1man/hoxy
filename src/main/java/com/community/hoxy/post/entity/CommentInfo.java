package com.community.hoxy.post.entity;

import com.community.hoxy.post.dto.CommentInsertDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comment_info")
public class CommentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "user_id")
    private String userId;

    private String content;

    @Column(name = "like_count")
    private Integer likeCount=0;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    // 생성자
    public CommentInfo() {}

    // getter와 setter
    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
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


    public static CommentInfo from(CommentInsertDTO commentInsertDTO){
        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setPostId(commentInsertDTO.getPostId());
        commentInfo.setUserId(commentInsertDTO.getUserId());
        commentInfo.setContent(commentInsertDTO.getContent());

        return commentInfo;
    }
}
