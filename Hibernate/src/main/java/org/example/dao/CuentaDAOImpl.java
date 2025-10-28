package org.example.dao;

import org.example.entities.Cuenta;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class CuentaDAOImpl implements CuentaDAO {


    @Override
    public List<Cuenta> findAll() {
        Session s1 = HibernateUtil.getSessionFactory().openSession();

        List<Cuenta> list = s1.createQuery("from Cuenta").list();
        s1.close();
        return list;
    }

    @Override
    public Cuenta findById(Long id) {
        Session s1 = HibernateUtil.getSessionFactory().openSession();
        Cuenta c1 = s1.createQuery("from Cuenta where id = :id", Cuenta.class).setParameter("id", id).uniqueResult();

        return c1;
    }

    @Override
    public Cuenta create(Cuenta c) {
        Session s1 = HibernateUtil.getSessionFactory().openSession();
        try {
            s1.getTransaction().begin();
            s1.persist(c);
            s1.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            s1.getTransaction().rollback();
        } finally {
            s1.close();
        }
        return c;
    }

    @Override
    public Cuenta update(Cuenta c) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
