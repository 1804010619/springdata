package com.wang.dao.impl;

import com.wang.dao.UsersDao;
import com.wang.pojo.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wanglimin
 * @date 2020-05-29 19:50
 */
@Repository
public class UserDaoImpl implements UsersDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void insertUsers(Users users) {
        this.hibernateTemplate.save(users);
    }

    @Override
    public void updateUsers(Users users) {
        this.hibernateTemplate.update(users);
    }

    @Override
    public void deleteUsers(Users users) {
        this.hibernateTemplate.delete(users);
    }

    @Override
    public Users selectUsersById(Integer userid) {
        return this.hibernateTemplate.get(Users.class,userid);
    }

    @Override
    public List<Users> selectUsersByName(String username) {
        //getCurrnetSession:当前Session必须要有事务边界，并且只能处理唯一的一个事务，当事务提交或回滚后session自动失效
        //openSession：每次都会打开一个新的Session，加入每次使用多次，则获得的是不同的Session对象。使用完毕后需要手动调用close方法关闭Session
        SessionFactory sessionFactory = this.hibernateTemplate.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users where username=:abc");
        query.setParameter("abc",username);
        List<Users> list = query.list();
        return list;
    }

    @Override
    public List<Users> selectUsresByNameUseSql(String username) {
        Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
        NativeQuery sqlQuery = session.createSQLQuery("select * from t_users where username=?");
        sqlQuery.addEntity(Users.class);
        sqlQuery.setParameter(1,username);
        return sqlQuery.list();
    }

    @Override
    public List<Users> selectUsersByNameUserCriteria(String username) {
        Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq(username,username));
        List<Users> list = criteria.list();
        return list;
    }
}
