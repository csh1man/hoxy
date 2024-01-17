package com.community.hoxy.post.service;

import com.community.hoxy.post.dto.CommentInsertDTO;
import com.community.hoxy.post.dto.PostInsertDTO;
import com.community.hoxy.post.entity.CommentInfo;
import com.community.hoxy.post.entity.PostInfo;
import com.community.hoxy.post.repository.CommentRepository;
import com.community.hoxy.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 게시글에 대한 서비스 로직을  처리
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    /**
     * 새로운 게시글을 디비에 삽입한다
     * @param postInsertDTO 클라이언트로부터 전달받은 게시글 정보
     */
    public int insertNewPostInfo(PostInsertDTO postInsertDTO){
        PostInfo postInfo = PostInfo.from(postInsertDTO);
        PostInfo savedInfo = postRepository.save(postInfo);
        if(savedInfo != null){
            return savedInfo.getPostId();
        }

        return -1;
    }

    public CommentInfo insertNewContentInfo(CommentInsertDTO commentInsertDTO){
        CommentInfo commentInfo = CommentInfo.from(commentInsertDTO);
        CommentInfo savedInfo = commentRepository.save(commentInfo);

        return savedInfo;
    }
}
