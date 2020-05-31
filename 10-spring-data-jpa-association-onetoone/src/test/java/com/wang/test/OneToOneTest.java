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
 * @date 2020-05-30 20:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OneToOneTest {
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
        users.setUsername("赵小刚");
        //建立关系
        users.setRoles(roles);
        roles.setUsers(users);
        //保存数据
        this.usersDao.save(users);
    }
    /**
     * 根据用户id查询用户，同时查询用户角色
     */
    @Test
    public void test2(){
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("userid"),16);
            }
        };
        Optional<Users> user = this.usersDao.findOne(specification);
        System.out.println(user.get());
        Roles roles = user.get().getRoles();
        System.out.println(roles);
    }
}
