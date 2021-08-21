package com.tpadsz.model;

import javax.persistence.*;

@Entity
@Table(name = "t_stu")
public class Student {

    private int id;
    private String name;
    private String stuNo;
    private ClassRoom classRoom;

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

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    /**
     * 使用Many-to-one来说明Student与ClassRoom是多对一的关系
     * JoinColumn说明外键，name属性指定外键的列名
     */
    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "cid")
    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Student() {
    }

    public Student(int id, String name, String stuNo, ClassRoom classRoom) {
        super();
        this.id = id;
        this.name = name;
        this.stuNo = stuNo;
        this.classRoom = classRoom;
    }

    public Student(String name, String stuNo, ClassRoom classRoom) {
        super();
        this.name = name;
        this.stuNo = stuNo;
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", stuNo=" + stuNo
                + ", classRoom=" + classRoom + "]";
    }
}