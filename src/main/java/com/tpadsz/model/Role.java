package com.tpadsz.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hongjian.chen on 2018/3/14.
 */

@Entity
@Table(name = "t_role")
public class Role {

    private int id;
    private String name;
    private Set<User> users;

    /**
     * 使用JionTable来配置多对多，
     * name表示关系表的名称
     * joinColumns表示我在关系表中的外键，注意是数组，所以需要加入{}表示
     *
     * @JoinColumn(name="rid") 表示外键为rid
     * inverseJoinColumns={@JoinColumn(name="uid")}表示
     * 对方在关系表中的外键
     */
    @ManyToMany
    @JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "rid")},
            inverseJoinColumns = {@JoinColumn(name = "uid")})
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + "]";
    }
}
