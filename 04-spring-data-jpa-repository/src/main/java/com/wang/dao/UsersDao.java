package com.wang.dao;

import com.wang.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author wanglimin
 * @date 2020-05-29 19:48
 *
 * repository接口
 */
public interface UsersDao extends Repository<Users,Integer> {


    List<Users> findByUsernameIs(String 王五);

    List<Users> findByUsernameLike(String s);

    List<Users> findByUsernameAndUserageGreaterThanEqual(String name,Integer age);
}
