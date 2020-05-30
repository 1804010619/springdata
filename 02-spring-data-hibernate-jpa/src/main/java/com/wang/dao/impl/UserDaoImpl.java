package com.wang.dao.impl;

import com.wang.dao.UsersDao;
import com.wang.pojo.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author wanglimin
 * @date 2020-05-29 19:50
 */
@Repository
public class UserDaoImpl implements UsersDao {

    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void insertUsers(Users users) {
        this.entityManager.persist(users);
    }

    @Override
    public void updateUsers(Users users) {
        this.entityManager.merge(users);
    }

    @Override
    public void deleteUsers(Users users) {
        Users u = this.selectUsersById(users.getUserid());
        this.entityManager.remove(u);
    }

    @Override
    public Users selectUsersById(Integer userid) {
        return  this.entityManager.find(Users.class,userid);
    }

    @Override
    public List<Users> selectUsersByName(String username) {
        Query query = this.entityManager.createQuery("from Users where username=:aaa");
        query.setParameter("aaa",username);
        return query.getResultList();
    }

    @Override
    public List<Users> selectUsresByNameUseSql(String username) {
        Query query = this.entityManager.createNativeQuery("select * from t_users where username=?", Users.class);
        query.setParameter(1,username);
        return query.getResultList();
    }

    @Override
    public List<Users> selectUsersByNameUserCriteria(String username) {
        //CriteriaBuilder对象，创建一个CriteriaQuery,创建一个查询条件
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        //CriteriaQuery对象，执行查询的Criteria对象
        CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
        //获取要查询的实体类的对象
        Root<Users> root = query.from(Users.class);
        //封装查询条件
        Predicate predicate = criteriaBuilder.equal(root.get("username"),username);
        query.where(predicate);
        TypedQuery<Users> typedQuery = this.entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
