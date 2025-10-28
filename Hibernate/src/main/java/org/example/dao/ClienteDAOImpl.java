package org.example.dao;

import org.example.entities.Cliente;
import org.example.entities.dao.ClienteDAO;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public List<Cliente> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> clientes = session.createQuery("from Cliente", Cliente.class).list();

        session.close();
        return clientes;
    }

    @Override
    public Cliente findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = session.createQuery("from Cliente where id = :id", Cliente.class).setParameter("id", id).uniqueResult();
//        Cliente cliente = session.find(Cliente.class, id);
        session.close();
        return cliente;
    }

    @Override
    public Cliente findByIdEager(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = session.createQuery("from Cliente c join fetch c.cuentas where c.id = :id", Cliente.class).setParameter("id", id).uniqueResult();
//        Cliente cliente = session.find(Cliente.class, id);
        session.close();
        return cliente;
    }


    @Override
    public Cliente findByLastName(String lastName) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Cliente customer = session.createQuery("from Cliente where lastName = :lastName", Cliente.class).setParameter("lastName", lastName).uniqueResult();
        session.close();

        return customer;
    }

    @Override
    public Cliente create(Cliente customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(customer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return customer;
    }

    @Override
    public Cliente update(Cliente customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.merge(customer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return customer;
    }

    @Override
    public boolean deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Cliente customer = this.findById(id);
            session.beginTransaction();
            session.remove(customer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
