package com.tpadsz.util;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {

        try {

            // Create the SessionFactory from hibernate.cfg.xml

            //sessionFactory = new Configuration().configure().buildSessionFactory();
        	sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        } catch (Throwable ex) {

            // Make sure you log the exception, as it might be swallowed

            System.err.println("Initial SessionFactory creation failed." + ex);

            throw new ExceptionInInitializerError(ex);

        }

    }

    public static SessionFactory getSessionFactory() {

        return sessionFactory;

    }
    
    public static void main(String[] args) {
		Session session=getSessionFactory().getCurrentSession();
		System.out.println("session="+session);
	}

}