package com.tpadsz.dao;

import java.util.List;


public interface BaseDao<E> {

	void save(E entity);
	List<E> selectAll();
	void deleteBy(E entity);
}
