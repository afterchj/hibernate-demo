package com.tpadsz.util;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {

        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

//            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);

            throw new ExceptionInInitializerError(ex);

        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Session session = getSessionFactory().getCurrentSession();
        System.out.println("session=" + session);
    }

}