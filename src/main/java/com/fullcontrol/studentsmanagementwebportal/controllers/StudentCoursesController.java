/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.controllers;

import com.fullcontrol.studentsmanagementwebportal.classes.Course;
import com.fullcontrol.studentsmanagementwebportal.classes.User;
import com.fullcontrol.studentsmanagementwebportal.dao.CourseDao;
import com.fullcontrol.studentsmanagementwebportal.dao.CourseDaoImpl;
import com.fullcontrol.studentsmanagementwebportal.dao.UserDao;
import com.fullcontrol.studentsmanagementwebportal.dao.UserDaoImpl;
import com.fullcontrol.studentsmanagementwebportal.util.Constant;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "StudentCoursesController", urlPatterns = {"/StudentCoursesController"})
public class StudentCoursesController extends HttpServlet {

    CourseDao courseDao = null;
    UserDao userDao = null;
    RequestDispatcher requestDispatcher = null;
    List<User> lecturersList = null;

    public StudentCoursesController() {
        courseDao = new CourseDaoImpl();
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int courseId = Integer.valueOf(request.getParameter("courseId"));

        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");
        List<Course> enrolledCoursesList = courseDao.getEnrolledCourses(userId);
        boolean courseAlreadyEnrolled = false;
        for (Course enrolledCourse : enrolledCoursesList) {
            if (enrolledCourse.getCourseId() == courseId) {
                courseAlreadyEnrolled = true;
                break;
            }
        }
        if (!courseAlreadyEnrolled) {
            if (courseDao.enrollCourse(courseId, userId)) {
                request.setAttribute("NOTIFICATION", "Course Enrolled Successfully!");
            }
        } else {
            request.setAttribute("NOTIFICATION", "Course Already Enrolled!");
        }
        getCourses(request, response);
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
                getCourses(request, response);
                break;

            case "Add":
                redirectToAdd(request, response);
                break;

            default:
                getCourses(request, response);
                break;

        }

    }

    private void getCourses(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");
        List<Course> coursesList = courseDao.getEnrolledCourses(userId);
        request.setAttribute("coursesList", coursesList);
        requestDispatcher = request.getRequestDispatcher("/views/studentCourses.jsp");
        requestDispatcher.forward(request, response);
    }

    private void redirectToAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Course> coursesList = courseDao.get();

        request.setAttribute("coursesList", coursesList);

        requestDispatcher = request.getRequestDispatcher("/views/enrolCourse.jsp");

        requestDispatcher.forward(request, response);
    }
}
