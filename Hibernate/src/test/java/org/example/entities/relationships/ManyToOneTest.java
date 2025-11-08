package org.example.entities.relationships;

import org.example.dao.ClienteDAOImpl;
import org.example.dao.CuentaDAOImpl;
import org.example.entities.Cliente;
import org.example.entities.Cuenta;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ManyToOneTest {
    private static Session session;
    private static ClienteDAOImpl clienteDAO;
    private static CuentaDAOImpl cuentaDAO;

    @BeforeAll
    static void init() {
        session = HibernateUtil.getSessionFactory().openSession();
        clienteDAO = new ClienteDAOImpl();
        cuentaDAO = new CuentaDAOImpl();
    }

    @AfterAll
    static void closeSession() {
        session.close();
    }

    @Test
    void cuentaClienteTest() {
        Cuenta c1 = new Cuenta(null, "345678", 2000);
        Cliente c = new Cliente(null, "David", "Munoz", "davmunher2@alu.edu.gva.es", 33);

        c1.setCliente(c);
        clienteDAO.create(c);
        cuentaDAO.create(c1);
        Cuenta cuentaDB = cuentaDAO.findById(1L);
        Cliente clienteRelacionado = cuentaDB.getCliente();
        System.out.println(clienteRelacionado);
    }

    @Test
    void clienteCuentasTest() {
        Cliente c = clienteDAO.findByIdEager(2l);
        List<Cuenta> cuentas = c.getCuentas();

        System.out.println(cuentas);
    }

}

