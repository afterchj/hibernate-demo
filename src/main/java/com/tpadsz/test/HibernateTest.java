package com.tpadsz.test;


import com.tpadsz.model.*;
import com.tpadsz.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateTest {

    @Test
    public void test() {
        System.out.println(HibernateUtil.getSession());
    }

    @Test
    public void test1() {

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //我们先添加一方，再添加多方
        ClassRoom c = new ClassRoom();
        c.setName("梁山班");
        Student stu1 = new Student("宋江", "001", c);
        Student stu2 = new Student("吴用", "003", c);
//        session.save(c);
//        session.save(stu1);
//        session.save(stu2);
//        tx.commit();

        List<Student> list = session.createQuery("from Student").list();
        for (Student student : list) {
            System.out.println(student.getName());
        }
    }

    @Test
    public void test2() {

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //如果我们先添加多的一方呢？
        Student stu1 = new Student();
        stu1.setName("孙悟空");
        stu1.setStuNo("001");
        Student stu2 = new Student();
        stu2.setName("猪八戒");
        stu2.setStuNo("002");
        Set<Student> students = new HashSet<Student>();
        students.add(stu1);
        students.add(stu2);
        ClassRoom c = new ClassRoom();
        c.setName("西游班");
        c.setStudents(students);

//        stu1.setClassRoom(c);
//        stu2.setClassRoom(c);

//        session.save(stu1);
//        session.save(stu2);
        session.save(c);
        tx.commit();

        session.close();
    }

    @Test
    public void test3() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        //我们先添加一方，再添加多方
        ClassRoom c = new ClassRoom();
        c.setName("红楼班");

        Student stu1 = new Student("贾宝玉", "001", c);
        session.save(stu1);
        Student stu2 = new Student("林黛玉", "003", c);
//        stu1.setClassRoom(c);
//        stu2.setClassRoom(c);
        session.save(stu2);
        session.save(c);
        tx.commit();
        session.close();
    }

    @Test
    public void testLoad01() {
        Session session = HibernateUtil.getSession();
        ClassRoom cls = (ClassRoom) session.load(ClassRoom.class, 1);
        System.out.println(cls.getName());
        Set<Student> students = cls.getStudents();
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    @Test
    public void testAdd01() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        /**
         * 我们先来保存多方
         */
        Student stu1 = new Student();
        stu1.setName("曹操");
        stu1.setStuNo("001");

        Student stu2 = new Student();
        stu2.setName("刘备");
        stu2.setStuNo("002");

        ClassRoom c = new ClassRoom();
        c.setName("三国班");
        stu2.setClassRoom(c);
        stu1.setClassRoom(c);

        Set<Student> stus = new HashSet<Student>();
        stus.add(stu1);
        stus.add(stu2);
        c.setStudents(stus);
        session.save(stu1);
        session.save(stu2);

//        session.save(c);

        tx.commit();
        session.close();
    }

    @Test
    public void testOneToOne1() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Person p = (Person) session.load(Person.class, 6);
        IDCard card = new IDCard("110170");
        card.setPerson(p);
        //将IDCard设置到用户属性中，表示这个一个一对一的关联
        //表示张三的身份证号码为:110120

        session.save(card);
//        session.save(p);

        tx.commit();
        session.close();
    }

    @Test
    public void testOneToOne2() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Person p = new Person("王五 ");
        //先插入不维护关系的一端：
        session.save(p);
        IDCard card = new IDCard("110150");
        card.setPerson(p);
        session.save(card);
        tx.commit();
    }

    @Test
    public void testManyToMany1() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        User user = new User("admin", "123456", "管理员",
                new Date());

        Role role1=new Role();
        role1.setName("修改数据");
        Role role2=new Role();
        role2.setName("查询数据");

        Set<Role> roles=new HashSet<Role>();
        roles.add(role1);
        roles.add(role2);
        user.setRoles(roles);

        session.save(user);
        session.save(role1);
        session.save(role2);
        tx.commit();
        session.close();

    }

    @Test
    public void ManyToMany2() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        User user1 = new User("张三", "123456", "测试员",
                new Date());
        User user2 = new User("李四", "123456", "观察员",
                new Date());

        Set<User> users=new HashSet<User>();
        users.add(user1);
        users.add(user2);
        Role role=new Role("添加数据");
        role.setUsers(users);

        session.save(user1);
        session.save(user2);
        session.save(role);
        tx.commit();
        session.close();
    }
}
