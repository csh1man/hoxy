package com.community.hoxy.user.service;

import com.community.hoxy.user.entity.UserInfo;
import com.community.hoxy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 닉네임이 존재하는 유무 확인
     * @param nickName 등록하고자하는 닉네임
     */
    public boolean isNickNameExist(String nickName){
        return userRepository.findByNickName(nickName).isPresent();
    }

    /**
     * ID 존재 유무 확인
     * @param id 등록하고자 하는 ID
     */
    public boolean isIdExist(String id){
        return userRepository.findById(id).isPresent();
    }

    /**
     * PASSWORD 올바름 유무 확인
     * @param password 클라이언트에서 보낸 PASSWORD
     * @return 
     *  0 : 비밀번호 틀림
     *  1 : 비밀번호 맞음
     *  2 : 존재하지 않는 아이디
     */
    public int isPasswordOk(String id, String password){
        Optional<UserInfo> userInfo = userRepository.findById(id);
        if(userInfo.isPresent()){
            if(password.equals(userInfo.get().getPwd())){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 2;
        }
    }
}
