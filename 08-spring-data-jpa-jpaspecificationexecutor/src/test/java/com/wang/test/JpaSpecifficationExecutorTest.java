package com.wang.test;

import antlr.collections.impl.LList;
import com.wang.dao.UsersDao;
import com.wang.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglimin
 * @date 2020-05-30 19:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaSpecifficationExecutorTest {
    @Autowired
    private UsersDao usersDao;

    /**
     * 根据用户姓名查询数据
     */
    @Test
    public void test1(){
        Specification<Users> specification = new Specification<Users>() {
            /**
             *
             * @param root  ：根对象，封装了查询条件
             * @param query ：定义了一个基本的查询，一般不使用
             * @param criteriaBuilder   ：创建一个查询条件
             * @return  Predicate:定义了查询条件
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.equal(root.get("username"), "王利民");
                return predicate;
            }
        };
        List<Users> list = this.usersDao.findAll(specification);
        for(Users users : list){
            System.out.println(users);
        }
    }

    /**
     * 多条件查询方式一
     * 使用用户姓名以及年龄查询数据
     */
    @Test
    public void test2(){
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("username"),"王利民"));
                list.add(criteriaBuilder.equal(root.get("userage"),22));
                //此时条件之间没有任何关系
                Predicate predicate = criteriaBuilder.and(list.get(0), list.get(1));
                return predicate;
            }
        };
        List<Users> list = this.usersDao.findAll(specification);
        for(Users users : list){
            System.out.println(users);
        }
    }

    /**
     * 多条件查询方式二
     * 使用用户姓名以及年龄查询数据
     */
    @Test
    public void test3(){
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                return criteriaBuilder.or(criteriaBuilder.equal(root.get("username"),"王利民"),criteriaBuilder.equal(root.get("userage"),22));
            }
        };
        List<Users> list = this.usersDao.findAll(specification);
        for(Users users : list){
            System.out.println(users);
        }
    }

    /**
     * 查询王姓用户，并且做分页处理
     */
    @Test
    public void test4(){
        //条件
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("username").as(String.class),"王%");
            }
        };
        //分页
        Pageable pageable = PageRequest.of(0,2);
        Page<Users> page = this.usersDao.findAll(specification, pageable);
        System.out.println("总条数"+page.getTotalElements());
        System.out.println("总页数"+page.getTotalPages());
        List<Users> list = page.getContent();
        for(Users users : list){
            System.out.println(users);
        }
    }
    /**
     * 查询数据库中王姓的用户并根据用户ID做降序排序
     */
    @Test
    public void test5(){
        //条件
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("username").as(String.class),"王%");
            }
        };
        //排序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"userid");
        Sort sort = Sort.by(order);
        List<Users> list = this.usersDao.findAll(specification, sort);
        for(Users users : list){
            System.out.println(users);
        }
    }

    /**
     * 查询数据库中王姓用户，做分页处理并根据用户ID做倒序查询
     */
    @Test
    public void test6(){
        //排序的定义
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"userid");
        Sort sort = Sort.by(order);
        //分页的定义
        Pageable pageable = PageRequest.of(0,3,sort);
        //查询条件
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("username").as(String.class),"王%");
            }
        };
        Page<Users> page = this.usersDao.findAll(specification, pageable);
        System.out.println("总条数"+page.getTotalElements());
        System.out.println("总页数"+page.getTotalPages());
        List<Users> list = page.getContent();
        for(Users users : list){
            System.out.println(users);
        }
    }

}
