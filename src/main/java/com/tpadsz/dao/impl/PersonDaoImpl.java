package com.tpadsz.dao.impl;

import java.util.List;

import com.tpadsz.dao.PersonDao;
import com.tpadsz.model.Person;

public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao{
	//BaseDaoImpl<Person> pBaseDaoImpl= new BaseDaoImpl<Person>();

	public static void main(String[] args) {
		PersonDaoImpl daoImpl=new PersonDaoImpl();
		List<Person> list=daoImpl.selectAll();
		System.out.println("list是否为空："+list.size());
		for (Person per:list) {
			System.out.println("name="+per.getName());
		}
	}
}
