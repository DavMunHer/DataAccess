package org.example.Hogwarts.Entities;

import java.util.Date;

public class Student {
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private int anoCurso;
    private Date fechaNacimiento;

    public Student(String nombre, String apellido, int anoCurso, Date fechaNacimiento, int idEstudiante) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.anoCurso = anoCurso;
        this.fechaNacimiento = fechaNacimiento;
        this.idEstudiante = idEstudiante;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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
