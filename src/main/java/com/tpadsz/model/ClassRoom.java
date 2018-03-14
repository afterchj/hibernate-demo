package com.tpadsz.model;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by hongjian.chen on 2018/3/13.
 */

@Entity
@Table(name = "t_cls_room")
public class ClassRoom {
    private int id;
    private String name;
    private Set<Student> students;

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
     * 在一方必须添加OneToMany，并且必须指定mappedBy属性
     * 因为如果不知道mapppedBy，那么hibernate会自动的创建一个
     * 两个表的关系表，作为两者的关系维护，只有我们知道了mappedBy
     * 则告诉hibernate，它们两者间的关系由一方在多方的属性classRoom
     * 这个多方的属性字段来维护
     */
    @OneToMany(mappedBy = "classRoom")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
