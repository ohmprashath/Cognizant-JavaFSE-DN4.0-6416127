package com.example.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.example.entity.Employee;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Failed to create SessionFactory: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
        sessionFactory.close();
    }
}
