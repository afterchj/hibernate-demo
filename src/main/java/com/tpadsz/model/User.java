package com.tpadsz.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by hongjian.chen on 2018/3/14.
 */

@Entity
@Table(name="t_users")
public class User {

    private int id;
    private String username;
    private String password;
    private String nickname;
    private Date bornDate;
    private Set<Role> roles;


    /**
     * 有我方在对方的属性来维护关系
     */
    @ManyToMany(mappedBy="users")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public User() {
    }

    public User(int id, String username, String password, String nickname,
                Date bornDate) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.bornDate = bornDate;
    }

    public User(String username, String password, String nickname, Date bornDate) {
        super();
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + ", nickname=" + nickname + ", bornDate="
                + bornDate + "]";
    }
}
