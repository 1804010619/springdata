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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wanglimin
 * @date 2020-05-30 13:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CrudRepositoryTest {
    @Autowired
    private UsersDao usersDao;

    /**
     * 添加单条数据
     */
    @Test
    public void test1(){
        Users users = new Users();
        users.setUserage(22);
        users.setUsername("王利民");
        this.usersDao.save(users);
    }

    /**
     * 批量添加数据
     */
    @Test
    public void test2(){
        Users users = new Users();
        users.setUserage(22);
        users.setUsername("王利民");
        List<Users> list = new ArrayList<>();
        list.add(users);

        Users users1 = new Users();
        users1.setUserage(32);
        users1.setUsername("你好");
        list.add(users1);
        this.usersDao.saveAll(list);
    }

    /**
     * 根据id查询单条数据
     */
    @Test
    public void test3(){
        Optional<Users> users = this.usersDao.findById(6);
        System.out.println(users);
    }

    /**
     * 查询全部数据
     */
    @Test
    public void test4(){
        List<Users> list = (List<Users>)this.usersDao.findAll();
        for(Users users : list){
            System.out.println(users);
        }
    }

    /**
     * 删除数据
     */
    @Test
    public void test5(){
        this.usersDao.deleteById(5);
    }

    /**
     * 更新数据:方式一
     */
    @Test
    public void test6(){
        Optional<Users> users = this.usersDao.findById(6);
        Users u = users.get();
        u.setUsername("王一");
        this.usersDao.save(u);
    }

    /**
     * 更新数据:方式二
     */
    @Test
    @Transactional
    @Rollback(false)
    public void test7(){
        Optional<Users> users = this.usersDao.findById(6);
        Users u = users.get();
        u.setUsername("王二");

    }
}
