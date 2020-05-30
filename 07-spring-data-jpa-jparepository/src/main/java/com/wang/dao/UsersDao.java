package com.wang.dao;

import com.wang.pojo.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author wanglimin
 * @date 2020-05-29 19:48
 *
 * PagingAndSortingRepository接口
 */
public interface UsersDao extends PagingAndSortingRepository<Users,Integer> {

}
