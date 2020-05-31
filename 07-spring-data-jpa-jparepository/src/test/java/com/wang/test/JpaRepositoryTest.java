package com.wang.test;

import com.wang.dao.UsersDao;
import com.wang.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wanglimin
 * @date 2020-05-30 18:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaRepositoryTest {
    @Autowired
    private UsersDao usersDao;

    /**
     * 查询全部数据
     */
    @Test
    public void test1(){
        List<Users> list = this.usersDao.findAll();
        for(Users users :list){
            System.out.println(users);
        }
    }


}
