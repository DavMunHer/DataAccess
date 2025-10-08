package org.example;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class JDBCMain {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().directory("./JDBC").load();
            Statement st = null;
        try {
            Connection cn = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASSWORD"));
            st = cn.createStatement();
            st.executeUpdate("DROP DATABASE IF EXISTS bank;");
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS bank;");
            st.executeUpdate("USE bank;");
            st.executeUpdate("CREATE TABLE Account(" +
                    "id INT PRIMARY KEY," +
                    "code VARCHAR(12)," +
                    "balance INT" +
                    ");");

            PreparedStatement ps =  cn.prepareStatement("INSERT INTO Account VALUES (?, ?, ?);");
            ps.setInt(1, 1);
            ps.setString(2, "000000000001");
            ps.setInt(3, 100);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
