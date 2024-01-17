package com.community.hoxy.post.repository;

import com.community.hoxy.post.entity.CommentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentInfo, Long> {
}
