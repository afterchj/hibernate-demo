package com.tpadsz.dao;

import java.util.List;

import org.hibernate.Session;

import com.tpadsz.model.Person;
import com.tpadsz.model.Teacher;
import com.tpadsz.util.HibernateUtil;

public class PersonManager {

	public static void main(String[] args) {

		createAndStorePerson();
		// deleteBy();
		selectBy();
		HibernateUtil.getSessionFactory().close();

	}

	private static void createAndStorePerson() {
		// 通过Session工厂获取Session对象
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction(); // 开始事务

		Teacher person = new Teacher();

		person.setUsername("hongjian");

		person.setAge(26);

		session.save(person);

		session.getTransaction().commit(); // 提交事务

	}

	private static void deleteBy() {
		// 通过Session工厂获取Session对象
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction(); // 开始事务

		Person person = new Person();

		person.setId(1);

		session.delete(person);

		session.getTransaction().commit(); // 提交事务

	}

	private static void selectBy() {
		// 通过Session工厂获取Session对象
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction(); // 开始事务

		@SuppressWarnings("unchecked")
		List<Teacher> pers = session.createQuery("from Teacher").list();
		for (Teacher per : pers) {
			System.out.println("name=" + per.getUsername());
		}
	}
}
