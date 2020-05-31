package com.wang.dao;


import com.wang.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wanglimin
 * @date 2020-05-29 19:48
 *
 * 一对多关联关系操作
 */

public interface UsersDao extends JpaRepository<Users,Integer>,JpaSpecificationExecutor<Users> {

}
