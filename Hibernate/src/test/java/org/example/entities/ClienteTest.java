package org.example.entities;

import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void createTablesTest() {
        Cliente cliente1 = new Cliente(null, "Yooo", "My bad", "mymail@mail.com", 20);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(cliente1);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        HibernateUtil.shutdown();
    }
}