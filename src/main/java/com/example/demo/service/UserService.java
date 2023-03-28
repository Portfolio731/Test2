package com.example.demo.service;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;
import com.example.demo.repository.UserRepository;
/**
 * ユーザー情報 Service
 */
@Service
public class UserService {
    /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private UserMapper userMapper;
    @Autowired
    UserRepository userRepository;
    /**
     * ユーザー情報検索
     * @param userSearchRequest リクエストデータ
     * @return 検索結果
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    public User search(UserSearchRequest userSearchRequest) {
        return userMapper.search(userSearchRequest);
    }
    
    public List<User> searchAll() {
        // ユーザーTBLの内容を全検索
        return userRepository.findAll();
    }
}