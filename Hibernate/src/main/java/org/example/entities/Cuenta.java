package org.example.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "cuentas")


public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String codigo;

    @Column
    private Integer saldo;

    @ManyToOne (cascade = CascadeType.ALL)
    private Cliente cliente;

    public Cuenta() {
    }

    public Cuenta(Long id, String codigo, Integer saldo) {
        this.id = id;
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
