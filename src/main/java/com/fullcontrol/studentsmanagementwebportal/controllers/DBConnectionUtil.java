/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lbust
 */
public class DBConnectionUtil {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Htial74185231991";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/students_managment?autoReconnect=true&useSSL=false";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static  Connection CONNECTION = null;

    public static Connection openConnection() {
        if (CONNECTION != null) {
            return CONNECTION;
        } else {
            try {
                Class.forName(DRIVER);
                CONNECTION = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return CONNECTION;
        }
    }
}
