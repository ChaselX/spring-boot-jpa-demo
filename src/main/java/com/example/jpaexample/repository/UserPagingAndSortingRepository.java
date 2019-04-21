package com.example.jpaexample.repository;

import com.example.jpaexample.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author XieLongzhen
 * @date 2019/4/21 16:42
 */
public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findByName(String name, Pageable pageable) throws Exception;
}
