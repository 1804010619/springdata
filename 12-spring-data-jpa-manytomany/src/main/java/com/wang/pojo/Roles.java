package com.wang.pojo;

import org.hibernate.annotations.Cascade;

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
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    //JoinTable:配置中间表
    //joinColumns:建立当前表在中间表的外键字段
    @JoinTable(name = "t_roles_menus",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<Menus> menus = new HashSet<>();

    @Override
    public String toString() {
        return "Roles{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", menus=" + menus +
                '}';
    }

    public Set<Menus> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menus> menus) {
        this.menus = menus;
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
