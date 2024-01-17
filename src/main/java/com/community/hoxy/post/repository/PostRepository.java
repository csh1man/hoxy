package com.community.hoxy.post.repository;

import com.community.hoxy.post.entity.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostInfo, Long> {

}
