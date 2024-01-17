package com.community.hoxy.post.controller;

import com.community.hoxy.post.dto.CommentInsertDTO;
import com.community.hoxy.post.dto.PostInsertDTO;
import com.community.hoxy.post.entity.CommentInfo;
import com.community.hoxy.post.entity.PostInfo;
import com.community.hoxy.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    @PostMapping(value = "/post/register-post")
    public ResponseEntity<?> insertNewPost(@RequestBody PostInsertDTO postDTO){
        int savedPostId = postService.insertNewPostInfo(postDTO);
        Map<String, Integer> response = new HashMap<>();
        response.put("result", savedPostId);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/post/register-comment")
    public ResponseEntity<?> insertNewComment(@RequestBody CommentInsertDTO commentInsertDTO){
        CommentInfo savedCommentInfo = postService.insertNewContentInfo(commentInsertDTO);

        return ResponseEntity.ok().body(savedCommentInfo);
    }
}
