package com.tpadsz.test;


import com.tpadsz.model.ClassRoom;
import com.tpadsz.model.Student;
import com.tpadsz.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

public class HibernateTest {

    @Test
    public void test() {
        System.out.println(HibernateUtil.getSession());
    }

    @Test
    public void test1(){

        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        ClassRoom c = new ClassRoom();
        c.setName("梁山班");
        session.save(c);
        Student stu1 = new Student("宋江", "001", c);
        session.save(stu1);
        Student stu2 = new Student("吴用", "003", c);
        session.save(stu2);
        tx.commit();

        List<Student> list=session.createQuery("from Student").list();
        for (Student student: list){
            System.out.println(student.getName());
        }
    }
}
