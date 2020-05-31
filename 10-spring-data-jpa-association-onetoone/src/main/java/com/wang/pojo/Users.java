package com.wang.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wanglimin
 * @date 2020-05-29 19:43
 */
@Entity
@Table(name = "t_users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "username")
    private String username;
    @Column(name = "userage")
    private Integer userage;
    /**
     * @JoinColumn,就是维护一个外键
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "roles_id")
    private Roles roles;

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userage=" + userage +
                '}';
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }
}
