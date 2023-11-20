package com.community.hoxy.post.controller;

import com.community.hoxy.post.dto.PostDTO;
import com.community.hoxy.post.entity.Post;
import com.community.hoxy.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 게시글에 대한 각종 처리를 담당하는 컨드롤러
 * RestController의 경우, 응답을 HTTP Protocol로 반환하는 기능을 수행할 수 있는 컨트롤러에 해당한다.
 */
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    /**
     * 새로운 게시글에 대한 정보를 저장
     */
    @PostMapping(value = "/post/insert")
    public void insertNewPost(@ModelAttribute PostDTO postDTO){
        Post post = postService.dtoToEntity(postDTO);
        postService.insertNewPost(post);
    }
}
