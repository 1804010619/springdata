package com.wang.dao;

import com.wang.pojo.Users;

import java.util.List;

/**
 * @author wanglimin
 * @date 2020-05-29 19:48
 */
public interface UsersDao {

    void insertUsers(Users users);
    void updateUsers(Users users);
    void deleteUsers(Users users);
    Users selectUsersById(Integer userid);

    List<Users> selectUsersByName(String username);

    List<Users> selectUsresByNameUseSql(String username);

    List<Users> selectUsersByNameUserCriteria(String username);
}
