package com.example.jpaexample.repository;

import com.example.jpaexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 通过源码和 CrudRepository 相比较
 * 其支持了 Query By Example、批量删除、提高删除效率、
 * 手动刷新数据库的更改方法，将默认实现的查询结果变成了 List。
 * <p>
 * SimpleJpaRepository 是 JPA 整个关联数据库的所有 Repository 的接口实现类
 *
 * @author XieLongzhen
 * @date 2019/5/24 20:28
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {
    List<User> findAllByName(String name);
}
