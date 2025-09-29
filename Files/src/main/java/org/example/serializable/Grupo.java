package org.example.serializable;

import java.io.Serializable;
import java.util.ArrayList;

public class Grupo implements Serializable {
    private String name;
    private ArrayList<Alumno> listaAlumnos;

    public Grupo(String name) {
        this.name = name;
        listaAlumnos = new ArrayList<Alumno>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Alumno> getListaAlumno() {
        return listaAlumnos;
    }

    public void addAlumno(Alumno al) {
        listaAlumnos.add(al);
    }

    public void listarAlumnos() {
        listaAlumnos.forEach(System.out::println);
    }

}
