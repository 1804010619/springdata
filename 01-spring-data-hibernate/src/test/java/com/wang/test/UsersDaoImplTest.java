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
 * @date 2020-05-29 19:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UsersDaoImplTest {

    @Autowired
    private UsersDao usersDao;
    /**
     * 添加用户
     */
    @Test
    @Transactional//在测试类中对于事务提交方式默认是回滚
    @Rollback(false)//取消自动回滚
    public void testInsertUsers(){
        Users users = new Users();
        users.setUserage(20);
        users.setUsername("张三");
        this.usersDao.insertUsers(users);
    }

    /**
     * 更新用户
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testUpdateUsers(){
        Users users = new Users();
        users.setUserid(2);
        users.setUserage(22);
        users.setUsername("李四");
        this.usersDao.updateUsers(users);
    }

    /**
     * 根据userid查询用户
     */
    @Test
    public void testSelectUsersById(){
        Users users = this.usersDao.selectUsersById(2);
        System.out.println(users);
    }

    /**
     * 删除用户
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteUsers(){
        Users users = new Users();
        users.setUserid(2);
        this.usersDao.deleteUsers(users);
    }
    /**
     * HQL测试
     */
    @Test
    @Transactional
    public void testSelectUserByName(){
        List<Users> users = this.usersDao.selectUsersByName("张三");
        for(Users u : users){
            System.out.println(u);
        }
    }

    /**
     * SQL测试
     */
    @Test
    @Transactional
    public void testSelectUserByNameUseSql(){
        List<Users> users = this.usersDao.selectUsresByNameUseSql ("张三");
        for(Users u : users){
            System.out.println(u);
        }
    }

    /**
     * SQL测试
     */
    @Test
    @Transactional
    public void testSelectUserByNameUserCriteria(){
        List<Users> users = this.usersDao.selectUsersByNameUserCriteria ("张三");
        for(Users u : users){
            System.out.println(u);
        }
    }



}
