 package com.tpadsz.test;

import java.util.List;

import com.tpadsz.dao.impl.PersonDaoImpl;
import com.tpadsz.model.Person;

public class HibernateTest {

	public static void main(String[] args) {
		PersonDaoImpl pImpl = new PersonDaoImpl();
		List<Person> list = pImpl.selectAll();
		System.out.println(list.size());
	}
}
