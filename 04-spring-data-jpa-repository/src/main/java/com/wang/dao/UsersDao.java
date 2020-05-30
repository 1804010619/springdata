package com.wang.dao;

import com.wang.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author wanglimin
 * @date 2020-05-29 19:48
 *
 * repository接口
 */
public interface UsersDao extends Repository<Users,Integer> {
    /**
     * 方法名称命名规则
     */
    List<Users> findByUsernameIs(String name);
    List<Users> findByUsernameLike(String s);
    List<Users> findByUsernameAndUserageGreaterThanEqual(String name,Integer age);
    /**
     *  使用@query注解查询
     */
    @Query(value = "from Users where username = ?1")
    List<Users> quaryUserByNameUseJpql(String name);
    @Query("from Users where username like ?1")
    List<Users> queryUserByLikeNameUseJPQL(String name);
    @Query("from Users where username=?1 and userage>=?2")
    List<Users> queryUserByNameAndAge(String name,Integer age);

    /**
     * 使用@Query注解查询SQL
     *
     * nativeQuery : 默认是false。表示不开启SQL查询。是否对value中的语句做转义
     */
    @Query(value = "select * from t_users where username=?1",nativeQuery = true)
    List<Users> queryUserByNameUseSQL(String name);


    @Query("update Users set userage=?1 where userid=?2")
    @Modifying  //当前的语句是一个更新语句
    void updateUserageById(Integer userage,Integer userid);

}
