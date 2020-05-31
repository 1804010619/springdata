package com.wang.dao;

import com.wang.pojo.Users;

/**
 * @author wanglimin
 * @date 2020-05-30 20:27
 */
public interface UsersRepository {
    public Users findUserById(Integer userid);
}
