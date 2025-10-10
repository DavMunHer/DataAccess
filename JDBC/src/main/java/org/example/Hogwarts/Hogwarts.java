package org.example.Hogwarts;

import org.example.Hogwarts.Entities.Asignatura;
import org.example.Hogwarts.Entities.Estudiante;
import org.example.Hogwarts.Entities.Mascota;

import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Hogwarts {

    public static List<Estudiante> consultaEstudiantesPorCasa(Connection conexion, String
            nombreCasa) throws SQLException {
        String consultaSQL = "SELECT e.id_estudiante, e.nombre, e.apellido, e.id_casa, e.año_curso, e.fecha_nacimiento " +
                "FROM Estudiante e " +
                "JOIN Casa c ON e.id_casa = c.id_casa " +
                "WHERE c.nombre_casa = ?";
        PreparedStatement consulta = conexion.prepareStatement(consultaSQL);
        consulta.setString(1, nombreCasa);
        ResultSet resultados = consulta.executeQuery();
        List<Estudiante> estudiantes = new ArrayList<>();
        while (resultados.next()) {
            estudiantes.add(new Estudiante(
                    resultados.getInt("id_estudiante"),
                    resultados.getString("nombre"),
                    resultados.getString("apellido"),
                    resultados.getInt("año_curso"),
                    resultados.getString("fecha_nacimiento"),
                    resultados.getInt("id_casa")
            ));
        }
        return estudiantes;
    }


    public static List<Asignatura> getCompulsorySubjects(Connection con, int compulsorySubjects) throws SQLException {
        if (compulsorySubjects != 0 && compulsorySubjects != 1) {
            System.out.println("The compulsory param can only be 1 (true) or 0 (false)");
            return null;
        }
        String SQLQuery = """
                SELECT * 
                FROM Asignatura
                WHERE obligatoria = ?             
                """;

        PreparedStatement ps = con.prepareStatement(SQLQuery);
        ps.setInt(1, compulsorySubjects);

        ResultSet rs = ps.executeQuery();
        List<Asignatura> filteredSubjects = new ArrayList<>();

        while (rs.next()) {
            filteredSubjects.add(
                    new Asignatura(
                        rs.getBoolean("obligatoria"),
                        rs.getString("aula"),
                        rs.getString("nombre_asignatura"),
                        rs.getInt("id_asignatura")
                    )
            );
        }
        return filteredSubjects;
    }

    public static Mascota getPetFrom(Connection con, String ownerName, String ownerSurname) throws SQLException {
        String SQLQuery = """
                SELECT m.id_mascota, m.nombre_mascota, m.especie FROM 
                Mascota m INNER JOIN Estudiante e
                ON m.id_estudiante = e.id_estudiante
                WHERE e.nombre = ? AND e.apellido = ?           
                """;
        PreparedStatement ps = con.prepareStatement(SQLQuery);
        ps.setString(1, ownerName);
        ps.setString(2, ownerSurname);

        ResultSet rs = ps.executeQuery();
        Mascota pet = null;
        while (rs.next()) {
            pet = new Mascota(
                    rs.getInt("id_mascota"),
                    rs.getString("nombre_mascota"),
                    rs.getString("especie")
            );
            break;
        }
        return pet;
    }

    public static List<Estudiante> getStudentsWithoutPet(Connection con) throws SQLException {
        String SQLQuery = """
                SELECT * FROM Estudiante e
                WHERE NOT EXISTS (SELECT 1 from Mascota WHERE id_estudiante = e.id_estudiante)
                """;
        PreparedStatement ps = con.prepareStatement(SQLQuery);

        ResultSet rs = ps.executeQuery();

        List<Estudiante> students = new ArrayList<>();

        while (rs.next()) {
            students.add(
                    new Estudiante(
                            rs.getInt("id_estudiante"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getInt("año_curso"),
                            rs.getString("fecha_nacimiento"),
                            rs.getInt("id_casa")
                    )
            );
        }
        return students;
    }

    public static double getAvarageScore(Connection con, String name, String surname) throws SQLException {
        String query = """
                SELECT AVG(calificacion) as avg FROM Estudiante_Asignatura
                WHERE id_estudiante =
                (SELECT id_estudiante FROM Estudiante WHERE nombre = ? AND apellido = ?);
                """;
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, surname);
        ResultSet rs = ps.executeQuery();

        double avgScore = 0;
        while (rs.next()) {
            avgScore = rs.getDouble("avg");
            break;
        }
        return avgScore;
    }


    public static int getStudentsPerHome(Connection con, String houseName) throws SQLException {
        String query = """
                SELECT Casa.nombre_casa, COUNT(*) AS Students
                FROM Estudiante es INNER JOIN Casa ON es.id_casa = Casa.id_casa
                WHERE Casa.nombre_casa = ?
                GROUP BY es.id_casa;        
                """;
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, houseName);

        ResultSet rs = ps.executeQuery();

        int studentsPerHome = 0;
        while (rs.next()) {
            studentsPerHome = rs.getInt("Students");
            break;
        }
        return studentsPerHome;
    }


    public static int insertNewStudent(Connection con, String name, String surname, int courseYear, String birthDate, int houseId) throws SQLException {
        String query = """
                INSERT INTO Estudiante(nombre, apellido, año_curso, fecha_nacimiento, id_casa) VALUES (?, ?, ?, ?, ?);
                """;
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, surname);
        ps.setInt(3, courseYear);
        ps.setString(4, birthDate);
        ps.setInt(5, houseId);

        return ps.executeUpdate();
    }



    public static void main(String[] args) {
        Path dbPath = Path.of("src", "main", "resources", "db", "hogwarts.db");

        Connection cn = null;

        try {
            cn = DriverManager.getConnection("jdbc:sqlite:" + dbPath.toString());
            List<Estudiante> estudiantesGryffindor = consultaEstudiantesPorCasa(cn,
                    "Gryffindor");
            estudiantesGryffindor.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
