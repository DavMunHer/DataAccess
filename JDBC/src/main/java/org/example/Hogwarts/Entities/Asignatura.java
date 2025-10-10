package org.example.Hogwarts.Entities;

public class Asignatura {
    private int idAsignatura;
    private String nombreAsignatura;
    private String aula;
    private boolean obligatoria;

    public Asignatura(boolean obligatoria, String aula, String nombreAsignatura, int idAsignatura) {
        this.obligatoria = obligatoria;
        this.aula = aula;
        this.nombreAsignatura = nombreAsignatura;
        this.idAsignatura = idAsignatura;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public boolean isObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "idAsignatura=" + idAsignatura +
                ", nombreAsignatura='" + nombreAsignatura + '\'' +
                ", aula='" + aula + '\'' +
                ", obligatoria=" + obligatoria +
                '}';
    }
}
