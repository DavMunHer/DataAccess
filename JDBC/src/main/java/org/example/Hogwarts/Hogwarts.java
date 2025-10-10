package org.example.Hogwarts;

import org.example.Hogwarts.Entities.Asignatura;
import org.example.Hogwarts.Entities.Estudiante;

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
