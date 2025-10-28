package org.example.entities.dao;

import org.example.entities.Cliente;

import java.util.List;

public interface ClienteDAO {

    /**
     * Get all the customers from the sql table
     * @return customers list
     */
    List<Cliente> findAll();

    /**
     * Search for a customer with the specified id and return its Java object
     * @param id The id of the customer
     * @return the specified customer if found. If not, returns null
     */
    Cliente findById(Long id);

    Cliente findByIdEager(Long id);



    Cliente findByLastName(String lastName);


    /**
     * Inserts a new customer in the table
     * @param customer
     * @return cliente
     */
    Cliente create(Cliente customer);


    /**
     * Edits a customer
     * @param customer
     * @return cliente
     */
    Cliente update(Cliente customer);


    /**
     * Deletes a customer from the db finding it by its id
     * @param id
     * @return true if deleted, false if not deleted
     */
    boolean deleteById(Long id);

}
