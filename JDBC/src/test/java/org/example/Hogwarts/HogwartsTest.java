package org.example.Hogwarts;


import org.example.Hogwarts.Entities.Asignatura;
import org.example.Hogwarts.Entities.Estudiante;
import org.example.Hogwarts.Entities.Mascota;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void testGetPetFrom() throws SQLException {
        Mascota pet = Hogwarts.getPetFrom(connection, "Hermione", "Granger");
        System.out.println(pet);
    }

    @Test
    void testGetStudentsWithoutPet() throws SQLException {
        List<Estudiante> students = Hogwarts.getStudentsWithoutPet(connection);
        students.forEach(System.out::println);
    }

    @Test
    void testGetAvgScore() throws SQLException {
        double avg = Hogwarts.getAvarageScore(connection, "Harry", "Potter");
        assertEquals(8.825, avg);
    }

    @Test
    void testGetStudentsPerHome() throws SQLException {
        int number = Hogwarts.getStudentsPerHome(connection, "Gryffindor");
        assertEquals(63, number);
    }

    @Test
    void testInsertNewStudent() throws SQLException {
        Hogwarts.insertNewStudent(connection, "Raul", "Hernandez", 2, "2022-07-05", 2);
    }

}