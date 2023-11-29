package com.community.hoxy.login.service;

import com.community.hoxy.login.dto.LoginRequest;
import com.community.hoxy.login.provider.JwtTokenProvider;
import com.community.hoxy.user.entity.UserInfo;
import com.community.hoxy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    public String createToken(LoginRequest loginRequest){
        /* userId로 사용자 정보 검색 */
        UserInfo userInfo = userRepository.findById(loginRequest.getId())
                .orElseThrow(IllegalArgumentException::new);
        return jwtTokenProvider.createToken(userInfo.getId());
    }
}
