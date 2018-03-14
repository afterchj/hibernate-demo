package com.tpadsz.model;

import javax.persistence.*;


@Entity
@Table(name = "t_person")
public class Person {
    private int id;

    private String name;

    private IDCard idCard;


    public Person() {
    }

    public Person(int id, String name, IDCard idCard) {
        super();
        this.id = id;
        this.name = name;
        this.idCard = idCard;
    }

    public Person(String name, IDCard idCard) {
        super();
        this.name = name;
        this.idCard = idCard;
    }

    public Person(String name) {
        super();
        this.name = name;
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

    /**
     * 有IDCard的person字段来维护关系
     */
    @OneToOne(mappedBy = "person")
    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
