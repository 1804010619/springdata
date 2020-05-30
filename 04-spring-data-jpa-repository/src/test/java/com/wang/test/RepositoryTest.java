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
 * @date 2020-05-30 10:29
 *
 * Repository接口测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RepositoryTest {
    @Autowired
    private UsersDao usersDao;

    /**
     * 需求：引入用户名做为查询条件
     */
    @Test
    public void test1(){
        //判断相等的条件，有三种表示方式
        //1.什么都不写，默认的是相等判断
        //2.Is
        //3.Equal
        List<Users> users = this.usersDao.findByUsernameIs("王五");
        for(Users u : users){
            System.out.println(u);
        }
    }

    /**
     * 需求：根据用户姓名做like处理
     * Like:条件关键字
     */
    @Test
    public void test2(){
        List<Users> li = this.usersDao.findByUsernameLike("王%");
        for(Users users : li){
            System.out.println(users);
        }
    }

    /**
     * 需求：查询名称为王五，并且年龄大于等于22
     */
    @Test
    public void test3(){
        List<Users> list = this.usersDao.findByUsernameAndUserageGreaterThanEqual("王五", 22);
        for(Users users : list){
            System.out.println(users);
        }
    }

    /**
     * 测试@quary注解的查询JPQL
     */
    @Test
    public void test4(){
        List<Users> list = this.usersDao.quaryUserByNameUseJpql("王五");
        for(Users users : list){
            System.out.println(users);
        }
    }

    /**
     * 测试@quary注解的查询JPQL
     */
    @Test
    public void test5(){
        List<Users> list = this.usersDao.queryUserByLikeNameUseJPQL("王%");
        for(Users users : list){
            System.out.println(users);
        }
    }

    /**
     * 测试@quary注解的查询JPQL
     */
    @Test
    public void test6(){
        List<Users> list = this.usersDao.queryUserByNameAndAge("王五",22);
        for(Users users : list){
            System.out.println(users);
        }
    }

    /**
     * 测试@quary注解的查询SQL
     */
    @Test
    public void test7(){
        List<Users> list = this.usersDao.queryUserByNameUseSQL("王五");
        for(Users users : list){
            System.out.println(users);
        }
    }

    /**
     * 测试@quary update
     */
    @Test
    @Transactional
    @Rollback(false)
    public void test8(){
        this.usersDao.updateUserageById(24,5);
    }
}
