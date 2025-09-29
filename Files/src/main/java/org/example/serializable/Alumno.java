package org.example.serializable;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String name;
    private String NIA;
    private int age;


    public Alumno(String name, String NIA, int age) {
        this.name = name;
        this.NIA = NIA;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNIA() {
        return NIA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNIA(String NIA) {
        this.NIA = NIA;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "name='" + name + '\'' +
                ", NIA='" + NIA + '\'' +
                ", age=" + age +
                '}';
    }
}
