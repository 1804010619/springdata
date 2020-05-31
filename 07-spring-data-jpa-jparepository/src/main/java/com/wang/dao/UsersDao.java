package com.wang.dao;

import com.wang.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author wanglimin
 * @date 2020-05-29 19:48
 *
 * jpaRepository接口
 */
public interface UsersDao extends JpaRepository<Users,Integer> {

}
