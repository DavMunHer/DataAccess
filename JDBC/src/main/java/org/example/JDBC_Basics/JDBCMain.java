package org.example.JDBC_Basics;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCMain {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().directory("./JDBC").load();
        Statement st = null;
        Connection cn = null;
        ResultSet rs = null;
        List<Account> accounts = new ArrayList<>();
        try {
            cn = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASSWORD"));
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

            rs = st.executeQuery("SELECT * FROM Account;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                int balance = rs.getInt("balance");
                Account ac = new Account(id, code, balance);
                accounts.add(ac);
            }

            accounts.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (rs !=  null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
