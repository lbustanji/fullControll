/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.controllers;

import com.fullcontrol.studentsmanagementwebportal.classes.ResulReturn;
import com.fullcontrol.studentsmanagementwebportal.classes.User;
import com.fullcontrol.studentsmanagementwebportal.dao.LoginDAO;
import com.fullcontrol.studentsmanagementwebportal.dao.LoginDAOImpl;
import com.fullcontrol.studentsmanagementwebportal.util.Constant;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lbust
 */
@WebServlet(name = "RegisterUserController", urlPatterns = {"/RegisterUserController"})
public class RegisterUserController extends HttpServlet {

    LoginDAO loginDAO = null;
    RequestDispatcher requestDispatcher = null;

    public RegisterUserController() {
        loginDAO = new LoginDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String privilegeSchema = request.getParameter("privilegeSchema");
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");

        user.setFullName(fullName);
        user.setEmail(email);
        user.setPrivilegeSchema(Integer.valueOf(privilegeSchema));
        user.setLoginId(loginId);
        user.setPassword(password);
        loginDAO.signUp(user);
        response.sendRedirect("/StudentsManagementWebPortal/views/Login.jsp");
    }

}
