package com.example.jpaexample.repository;

import com.example.jpaexample.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author XieLongzhen
 * @date 2019/5/29 10:07
 */
public interface UserCrudRepository extends CrudRepository<User, Long> {

}
