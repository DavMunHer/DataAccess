package org.example.Hogwarts;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hogwarts {
    public static void main(String[] args) {
        Path dbPath = Path.of("src", "main", "resources", "db", "hogwarts.db");

        Connection cn = null;

        try {
            cn = DriverManager.getConnection("jdbc:sqlite:" + dbPath.toString());


        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

}
