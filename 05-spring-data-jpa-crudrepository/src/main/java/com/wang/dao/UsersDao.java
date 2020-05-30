package com.wang.dao;

import com.wang.pojo.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author wanglimin
 * @date 2020-05-29 19:48
 *
 * crudRepository接口
 */
public interface UsersDao extends CrudRepository<Users,Integer> {

}
