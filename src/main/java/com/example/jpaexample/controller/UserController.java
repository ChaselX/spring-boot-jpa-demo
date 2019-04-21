package com.example.jpaexample.controller;

import com.example.jpaexample.entity.User;
import com.example.jpaexample.repository.UserPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XieLongzhen
 * @date 2019/4/19 11:02
 */
@Controller
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    /**
     * 验证排序和分页查询方法，Pageable的默认实现类：PageRequest
     *
     * @return
     */
    @GetMapping(path = "/page")
    @ResponseBody
    public Page<User> getAllUserByPage() {
        return userPagingAndSortingRepository.findAll(
                PageRequest.of(1, 20, Sort.by(Sort.Order.asc("name"))));
    }

    /**
     * 排序查询方法，使用Sort对象
     *
     * @return
     */
    @GetMapping(path = "/sort")
    @ResponseBody
    public Iterable<User> getAllUsersWithSort() {
        return userPagingAndSortingRepository.findAll(
                Sort.by(Sort.Order.asc("name")));
    }
}
