package com.wang.test;

import com.wang.dao.UsersDao;
import com.wang.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglimin
 * @date 2020-05-30 15:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PagingAndSortingRepositoryTest {
    @Autowired
    private UsersDao usersDao;

    /**
     * 分页
     */
    @Test
    public void test1(){
//        int page = 0;    //page:当前页的索引，索引从0开始
//        int size = 3;
//        Pageable pageable = new PageRequest(page,size);
//        this.usersDao.findAll();
    }

    /**
     * 对单列做排序处理
     */
    @Test
    public void test2(){
        //Sort :该对象封装了排序规则以及指定的排序字段(对象的属性来表示)
        //direction : 排序规则
        //properties:指定做排序的属性
//        Sort sort = Sort.by(Sort.Direction.DESC);
//        sort.by("userid");
//        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"userid");
//        Sort s= new Sort(order);
//        List<Users> list = (List<Users>) this.usersDao.findAll(sort);
//        for(Users users : list){
//            System.out.println(users);
//        }
    }

}
