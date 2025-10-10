package org.example.Hogwarts.Entities;

import java.util.Date;

public class Estudiante {
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private int anoCurso;
    private String fechaNacimiento;
    private int idCasa;

    public Estudiante(int idEstudiante, String nombre, String apellido, int anoCurso, String fechaNacimiento, int idCasa) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anoCurso = anoCurso;
        this.fechaNacimiento = fechaNacimiento;
        this.idCasa = idCasa;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getAnoCurso() {
        return anoCurso;
    }

    public void setAnoCurso(int anoCurso) {
        this.anoCurso = anoCurso;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idEstudiante=" + idEstudiante +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", anoCurso=" + anoCurso +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
