package com.example.jpaexample.service;

import com.example.jpaexample.entity.User;
import com.example.jpaexample.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XieLongzhen
 * @date 2019/5/29 10:26
 */
@Service
public class UserService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Cacheable(key = "'users:'+#name")
    public List<User> findAllByName(String name) {
        return userJpaRepository.findAllByName(name);
    }
}
