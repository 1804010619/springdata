package com.wang.test;

import com.wang.dao.UsersDao;
import com.wang.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wanglimin
 * @date 2020-05-30 20:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyRepositoryTest {
    @Autowired
    private UsersDao usersDao;
    @Test
    public void test1(){
        Users user = this.usersDao.findUserById(15);
        System.out.println(user);
    }
}
