package com.example.jpaexample.repository;

import com.example.jpaexample.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author XieLongzhen
 * @date 2019/4/19 10:59
 */
public interface UserRepository extends CrudRepository<User, Long> {
    
}
