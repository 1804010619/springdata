package com.wang.test;

import com.wang.dao.RolesDao;
import com.wang.pojo.Menus;
import com.wang.pojo.Roles;
import org.hibernate.criterion.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.management.relation.Role;
import javax.persistence.ManyToMany;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;
import java.util.Set;

/**
 * @author wanglimin
 * @date 2020-05-31 09:58
 *
 * 多对多关联关系测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManyToManyTest {
    @Autowired
    private RolesDao rolesDao;

    /**
     * 添加角色同时添加菜单
     */
    @Test
    public void test1(){
        //创建角色对象
        Roles roles = new Roles();
        roles.setRolename("超级管理员");
        //创建菜单对象
        Menus menus = new Menus();
        menus.setMenusname("xxx管理平台");
        menus.setFatherid(-1);
        menus.setMenusurl(null);
        //用户管理菜单
        Menus menus1 = new Menus();
        menus1.setMenusname("用户管理");
        menus1.setFatherid(1);
        menus1.setMenusurl(null);
        //建立关系
        roles.getMenus().add(menus);
        roles.getMenus().add(menus1);

        menus.getRoles().add(roles);
        menus1.getRoles().add(roles);
        //保存数据
        this.rolesDao.save(roles);
    }

    /**
     * 查询Roles
     */
    @Test
    public void test2(){
        Specification<Roles> specification = new Specification<Roles>() {
            @Override
            public Predicate toPredicate(Root<Roles> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("roleid"),3);
            }
        };

        Optional<Roles> optional = this.rolesDao.findOne(specification);
        Roles roles = optional.get();
        System.out.println("角色信息"+roles);
        Set<Menus> menus = roles.getMenus();
        for(Menus menus1 : menus){
            System.out.println("菜单信息"+menus1);
        }
    }
}
