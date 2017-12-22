package com.tpadsz.dao.impl;

import java.util.List;

import com.tpadsz.dao.TeacherDao;
import com.tpadsz.model.Teacher;

public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao {
	public static void main(String[] args) {
		TeacherDaoImpl tdDaoImpl = new TeacherDaoImpl();
		List<Teacher> list = tdDaoImpl.selectAll();
		System.out.println("list是否为空：" + list.size());
		for (Teacher per : list) {
			System.out.println("name=" + per.getUsername());
		}
	}
}
