package com.wang.dao;


import com.wang.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wanglimin
 * @date 2020-05-29 19:48
 *
 * JpaSpecificationExecutor<Users>接口不能单独使用，需要配合着jpa的其他接口一起使用
 */
public interface UsersDao extends JpaRepository<Users,Integer>,JpaSpecificationExecutor<Users> {

}
