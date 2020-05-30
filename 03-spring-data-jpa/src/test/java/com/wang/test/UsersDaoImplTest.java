package com.wang.test;

import com.wang.dao.UsersDao;
import com.wang.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * @author wanglimin
 * @date 2020-05-30 07:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UsersDaoImplTest {
    @Autowired
    private UsersDao usersDao;
    @Test
    @Transactional
    @Rollback(false)
    public void testInsertUsers(){
        Users users = new Users();
        users.setUserage(22);
        users.setUsername("王五");
        this.usersDao.save(users);
    }

}
