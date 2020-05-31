package com.wang.dao;

import com.wang.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author wanglimin
 * @date 2020-05-30 20:31
 */
public class UsersDaoImpl implements UsersRepository {
    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager entityManager;
    @Override
    public Users findUserById(Integer userid) {
        return this.entityManager.find(Users.class,userid);
    }
}
