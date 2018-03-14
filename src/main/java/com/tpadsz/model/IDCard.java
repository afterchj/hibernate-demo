package com.tpadsz.model;

import javax.persistence.*;

/**
 * Created by hongjian.chen on 2018/3/14.
 */

@Entity
@Table(name = "t_id_card")
public class IDCard {


    private int id;
    private String no;
    private Person person;

    public IDCard() {
    }

    public IDCard(String no) {
        super();
        this.no = no;
    }

    public IDCard(int id, String no) {
        super();
        this.id = id;
        this.no = no;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    /**
     * persion字段在数据库中的外键是pid
     */
    @OneToOne
    @JoinColumn(name = "pid")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "IDCard [id=" + id + ", no=" + no + "]";
    }
}
