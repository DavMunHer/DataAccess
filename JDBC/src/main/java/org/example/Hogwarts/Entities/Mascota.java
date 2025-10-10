package org.example.Hogwarts.Entities;

public class Mascota {
    private int idMascota;
    private String nombreMascota;
    private String especie;


    public Mascota(int idMascota, String nombreMascota, String especie) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.especie = especie;
    }


    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "idMascota=" + idMascota +
                ", nombreMascota='" + nombreMascota + '\'' +
                ", especie='" + especie + '\'' +
                '}';
    }
}
