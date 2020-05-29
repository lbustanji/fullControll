/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lbust
 */
@WebServlet(name = "ConnectionController", urlPatterns = {"/ConnectionController"})
public class ConnectionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = "root";
        String password = "Htial74185231991";
        String jdbcUrl = "jdbc:mysql://localhost:3306/students_managment?autoReconnect=true&useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        try {

            PrintWriter writer = response.getWriter();
            writer.println("Connecting to DB" + jdbcUrl);
            Class.forName(driver);
//            Connection conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "Htial74185231991");
            Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
            writer.println("Connected Sucssessfully" );
            connection.close();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
