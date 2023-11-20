package com.community.hoxy.post.service;

import com.community.hoxy.post.dto.PostDTO;
import com.community.hoxy.post.entity.Post;
import com.community.hoxy.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 게시글에 대한 서비스 로직을  처리
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    /**
     * 새로운 게시글을 디비에 삽입한다
     * @param newPost 새로운 게시글을 디비에 삽입한다.
     */
    public boolean insertNewPost(Post newPost){
        if(postRepository.save(newPost) != null){
            return true;
        }
        return false;
    }

    /**
     * 클라이언트로부터 받은 postDTO 객체를 디비에 넣을 수 있는 post Entity 객체로 변환
     * @param postDTO 클라이언트로부터 받은 게시글 정보
     */
    public Post dtoToEntity(PostDTO postDTO){
        return new Post(postDTO);
    }
}
