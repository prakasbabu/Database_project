package com.example.database_project_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection databaseLink;

         String url = "jdbc:mysql://localhost/database_project?useSSL= false";
         String username ="root";
         String password = "Root1234";

        Class.forName("com.mysql.cj.jdbc.Driver");

        databaseLink = DriverManager.getConnection(url,username,password);
        return databaseLink;
    }




}
