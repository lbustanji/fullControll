/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.controllers;

import com.fullcontrol.studentsmanagementwebportal.classes.User;
import com.fullcontrol.studentsmanagementwebportal.dao.UserDao;
import com.fullcontrol.studentsmanagementwebportal.dao.UserDaoImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lbust
 */
@WebServlet(name = "UsersManagerController", urlPatterns = {"/UsersManagerController"})
public class UsersManagerController extends HttpServlet {

    UserDao userDao = null;
    RequestDispatcher requestDispatcher = null;

    public UsersManagerController() {
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "LIST";
        }

        switch (action) {

            case "LIST":
                getUsers(request, response);
                break;

            case "EDIT":
                getSingleUser(request, response);
                break;

//            case "DELETE":
//                getSingleUser(request, response);
//                break;
            default:
                getUsers(request, response);
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("userId");

        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setStatus(Integer.valueOf(request.getParameter("status")));
        user.setPrivilegeSchema(Integer.valueOf(request.getParameter("privilegeSchema")));
        user.setId(Integer.parseInt(id));
        if (userDao.update(user)) {
            request.setAttribute("NOTIFICATION", "User Updated Successfully!");
        }

        getUsers(request, response);
    }

    private void getUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> usersList = userDao.get();
        request.setAttribute("usersList", usersList);
        requestDispatcher = request.getRequestDispatcher("/views/usersManager.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getSingleUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        User user = userDao.getUser(Integer.parseInt(id));

        request.setAttribute("user", user);

        requestDispatcher = request.getRequestDispatcher("/views/userInfo.jsp");

        requestDispatcher.forward(request, response);
    }
}
