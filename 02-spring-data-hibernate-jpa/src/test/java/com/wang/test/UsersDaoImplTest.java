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
import java.util.List;

/**
 * @author wanglimin
 * @date 2020-05-29 21:31
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
        users.setUsername("李四");
        users.setUserage(25);
        this.usersDao.insertUsers(users);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testUpdateUsers(){
        Users users = new Users();
        users.setUsername("王五");
        users.setUserid(4);
        users.setUserage(32);
        this.usersDao.updateUsers(users);
    }

    @Test
    public void testSelectUsersById(){
        Users users = this.usersDao.selectUsersById(4);
        System.out.println(users);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteUsers(){
        Users users = new Users();
        users.setUserid(4);
        this.usersDao.deleteUsers(users);
    }

    @Test
    @Transactional
    public void testSelectUsersByName(){
        List<Users> list = this.usersDao.selectUsersByName("张三");
        for(Users users : list){
            System.out.println(users);
        }
    }

    @Test
    @Transactional
    public void selectUsresByNameUseSql(){
        List<Users> list = this.usersDao.selectUsresByNameUseSql("张三");
        for(Users users : list){
            System.out.println(users);
        }
    }

    @Test
    @Transactional
    public void selectUsersByNameUserCriteria(){
        List<Users> list = this.usersDao.selectUsersByNameUserCriteria("张三");
        for(Users users : list){
            System.out.println(users);
        }
    }

}
