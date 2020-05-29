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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    LoginDAO loginDAO = null;
    RequestDispatcher requestDispatcher = null;

    public LoginController() {
        loginDAO = new LoginDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = new User();
        String loginId = request.getParameter("LoginId");
        String password = request.getParameter("Password");

        user.setLoginId(loginId);
        user.setPassword(password);
        ResulReturn result = loginDAO.authenticate(user);

        if (result.getResultId() == Constant.OPERATION_SUCCESSFULLY) {
            session.setAttribute("loginId", loginId);
            session.setAttribute("userId", result.getIntValue());
            session.setAttribute("privilegeSchema", result.getStringValue());
            response.sendRedirect("/StudentsManagementWebPortal/UsersManagerController");
//            requestDispatcher = request.getRequestDispatcher("LecturerCoursesController");
//            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("views/Login.jsp" + "?status=" + result.getResultId());
        }
    }

}
