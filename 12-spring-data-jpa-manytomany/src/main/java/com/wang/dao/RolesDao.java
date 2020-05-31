package com.wang.dao;

import com.wang.pojo.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wanglimin
 * @date 2020-05-31 09:59
 *
 * 多对多关联关系
 */
public interface RolesDao extends JpaRepository<Roles,Integer> , JpaSpecificationExecutor<Roles> {

}
