package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.entity.Employee;

public class EmployeeDaoHibernate {

    public Integer addEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer employeeId = null;

        try {
            tx = session.beginTransaction();
            employeeId = (Integer) session.save(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeId;
    }
}
