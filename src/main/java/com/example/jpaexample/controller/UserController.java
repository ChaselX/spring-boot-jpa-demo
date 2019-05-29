package com.example.jpaexample.controller;

import com.example.jpaexample.entity.User;
import com.example.jpaexample.repository.UserCrudRepository;
import com.example.jpaexample.repository.UserJpaRepository;
import com.example.jpaexample.repository.UserPagingAndSortingRepository;
import com.example.jpaexample.repository.UserRepository;
import com.example.jpaexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author XieLongzhen
 * @date 2019/4/19 11:02
 */
@RestController
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserService userService;

    /**
     * 验证排序和分页查询方法，Pageable的默认实现类：PageRequest
     *
     * @return
     */
    @GetMapping(path = "/page")
    public Page<User> getAllUserByPage() {
        return userPagingAndSortingRepository.findAll(
                PageRequest.of(0, 20, Sort.by(Sort.Order.asc("name"))));
    }

    /**
     * 排序查询方法，使用Sort对象
     *
     * @return
     */
    @GetMapping(path = "/sort")
    public Iterable<User> getAllUsersWithSort() {
        return userPagingAndSortingRepository.findAll(
                Sort.by(Sort.Order.asc("name")));
    }

    @GetMapping(path = "/info")
    public Optional<User> findOne(@RequestParam Long id) {
        return userCrudRepository.findById(id);
    }

    @GetMapping("/all")
    public List<User> findAll(@RequestParam String name) {
        return userService.findAllByName(name);
    }
}
