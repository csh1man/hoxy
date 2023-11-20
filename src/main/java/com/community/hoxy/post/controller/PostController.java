package com.community.hoxy.post.controller;

import com.community.hoxy.post.dto.PostDTO;
import com.community.hoxy.post.entity.Post;
import com.community.hoxy.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

/**
 * 게시글에 대한 각종 처리를 담당하는 컨드롤러
 */
@Controller
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
