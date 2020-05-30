package com.wang.dao;

import com.wang.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wanglimin
 * @date 2020-05-29 19:48
 *
 * JpaRepository<Users,主键类型>
 */
public interface UsersDao extends JpaRepository<Users,Integer> {


}
