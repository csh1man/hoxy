package com.community.hoxy.user.repository;

import com.community.hoxy.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, String> {
    Optional<UserInfo> findByNickName(String nickName);
    Optional<UserInfo> findById(String id);
}
