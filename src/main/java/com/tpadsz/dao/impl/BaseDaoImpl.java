package com.tpadsz.dao.impl;

import java.lang.reflect.ParameterizedType;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpadsz.dao.BaseDao;
import com.tpadsz.util.HibernateUtil;

public class BaseDaoImpl<E> implements BaseDao<E> {
	protected String className;
	protected Class<E> entityClass;
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		className = entityClass.getName();
		System.out.println("clasName="+className);
	}

	public void save(E entity) {
		// TODO Auto-generated method stub
		getSession().save(entity);

	}

	public List<E> selectAll() {
		// TODO Auto-generated method stub
		getSession().beginTransaction();
		List<E> list=getSession().createQuery("from " + className).list();
		//getSession().getTransaction().commit();
		return list;
	
	}

	public void deleteBy(E entity) {
		// TODO Auto-generated method stub

	}

	public Session getSession() {
		sessionFactory = HibernateUtil.getSessionFactory();
		return sessionFactory.getCurrentSession();
	}
}
