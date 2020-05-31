package com.wang.dao;


import com.wang.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author wanglimin
 * @date 2020-05-29 19:48
 *
 * 用户自定义Repository
 */

public interface UsersDao extends JpaRepository<Users,Integer>,JpaSpecificationExecutor<Users>,UsersRepository {

}
