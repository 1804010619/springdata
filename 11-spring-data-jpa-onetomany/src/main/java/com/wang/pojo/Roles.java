package com.wang.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wanglimin
 * @date 2020-05-30 20:46
 */
@Entity
@Table(name = "t_roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private Integer roleid;
    @Column(name = "rolename")
    private String rolename;
    @OneToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<>();

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
