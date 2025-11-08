
import org.example.dao.ClienteDAOImpl;
import org.example.entities.Cliente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClienteDAOImplTest {
    private static ClienteDAOImpl dao;

    @BeforeAll
    public static void setClass() {
        dao = new ClienteDAOImpl();
    }

    @Test
    public void testFindAll() {
        List<Cliente> clientes = dao.findAll();
        System.out.println(clientes);
    }

    @Test
    public void findById() {
        Cliente c1 = dao.findById(1l);
        System.out.println(c1);
    }

}
