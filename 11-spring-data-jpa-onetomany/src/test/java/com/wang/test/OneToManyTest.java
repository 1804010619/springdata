package com.wang.test;

import com.wang.dao.UsersDao;
import com.wang.pojo.Roles;
import com.wang.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

/**
 * @author wanglimin
 * @date 2020-05-31 09:28
 *
 * 一对多的关联关系测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OneToManyTest {
    @Autowired
    private UsersDao usersDao;

    /**
     * 添加用户同时添加角色
     */
    @Test
    public void test1(){
        //创建角色
        Roles roles = new Roles();
        roles.setRolename("管理员");
        //创建用户
        Users users = new Users();
        users.setUserage(30);
        users.setUsername("小王");
        //建立关系
        roles.getUsers().add(users);
        users.setRoles(roles);
        //保存用户
        this.usersDao.save(users);
    }

    /**
     * 根据用户ID查询用户信息，同时查询角色
     */
    @Test
    public void test2(){
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("userid"),18);
            }
        };
        Optional<Users> p = this.usersDao.findOne(specification);
        Users users = p.get();
        System.out.println(users);
        System.out.println(users.getRoles());
    }
}
