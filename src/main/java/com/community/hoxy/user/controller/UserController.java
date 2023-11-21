package com.community.hoxy.user.controller;

import com.community.hoxy.user.dto.UserInsertDTO;
import com.community.hoxy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 회원가입 절차에서 최종적으로 사용자 등록
     */
    @PostMapping(value="/user/register")
    public void registerUser(@ModelAttribute UserInsertDTO userInsertDTO){

    }
    
    /**
     * 닉네임 존재 유무 확인
     * @param request 닉네임 유무 검증에 필요한 데이터 객체
     * @return  result : false/true
     */
    @PostMapping(value="/user/check-nickname")
    public ResponseEntity<?> checkNickNameExist(@RequestBody Map<String, String> request){
        String nickname = request.get("nickname");
        Map<String, Boolean> response = new HashMap<>();
        response.put("result", userService.isNickNameExist(nickname));

        return ResponseEntity.ok().body(response);
    }

    /**
     * 아이디 존재 유무 확인
     * @param request 아이디 존재유무 검증에 필요한 데이터 객체
     * @return result : false/true
     */
    @PostMapping(value="/user/check-id")
    public ResponseEntity<?> checkIdExist(@RequestBody Map<String, String> request){
        String id = request.get("id");
        Map<String, Boolean> response = new HashMap<>();
        response.put("result", userService.isIdExist(id));

        return ResponseEntity.ok().body(response);
    }

    /**
     * 패스워드가 정상적인 지 확인
     * @request 패스워드 검증에 필요한 데이터 객체
     * @return
     *  0 : 비밀번호 틀림
     *  1 : 비밀번호 맞음
     *  2 : 존재하지 않는 ID
     */
    @PostMapping(value="/user/check-password")
    public ResponseEntity<?> checkPassword(@RequestBody Map<String, String> request){
        String id = request.get("id");
        String password = request.get("password");

        Map<String, Integer> response = new HashMap<>();
        response.put("result", userService.isPasswordOk(id, password));

        return ResponseEntity.ok().body(response);
    }
}
