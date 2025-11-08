package org.example.dao;

import org.example.entities.Cuenta;

import java.util.List;

public interface CuentaDAO {

    List<Cuenta> findAll();

    Cuenta findById(Long id);

    Cuenta create(Cuenta c);

    Cuenta update(Cuenta c);

    boolean deleteById(Long id);

}
