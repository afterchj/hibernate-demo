package com.tpadsz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
// 表示为实体类
@Table(name = "t_teacher")
// 表名注解
public class Teacher implements Serializable {

	private int id;

	private String username;

	private int age;

	@Id
	// 表示主键
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	// 自增长
	@Column(name = "id")
	// 类属性对应着表字段
	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	@Column(name = "t_username")
	// 类属性对应着表字段
	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	@Column(name = "t_age")
	// 在实体类属性进行注解，类属性对应着表字段
	public int getAge() {

		return age;

	}

	public void setAge(int age) {

		this.age = age;
	}
}