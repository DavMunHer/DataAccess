package org.example.Hogwarts;


import org.example.Hogwarts.Entities.Asignatura;
import org.example.Hogwarts.Entities.Estudiante;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

class HogwartsTest {
    private static Connection connection;

    @BeforeAll
    static void initDatabaseConnection() throws SQLException {
        System.out.println("Starting DB connection...\n");
        Path dbPath = Path.of("src", "main", "resources", "db", "hogwarts.db");
        connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath.toString());
    }

    @AfterAll
    static void closeDatabaseConnection() throws SQLException {
        System.out.println("\nClosing DB connection...");
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }


    @Test
    void consultaEstudiantesPorCasa() throws SQLException {
        List<Estudiante> students = Hogwarts.consultaEstudiantesPorCasa(connection, "Gryffindor");
        students.forEach(System.out::println);
    }

    @Test
    void testGetSubjects() throws SQLException {
        List<Asignatura> subjects = Hogwarts.getCompulsorySubjects(connection, 1);
        subjects.forEach(System.out::println);
    }



}