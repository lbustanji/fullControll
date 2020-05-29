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

/**
 *
 * @author lbust
 */
@WebServlet(name = "CoursesManagerController", urlPatterns = {"/CoursesManagerController"})
public class CoursesManagerController extends HttpServlet {

    CourseDao courseDao = null;
    UserDao userDao = null;
    RequestDispatcher requestDispatcher = null;
    List<User> lecturersList = null;

    public CoursesManagerController() {
        courseDao = new CourseDaoImpl();
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
                getCourses(request, response);
                break;

            case "EDIT":
                getSingleCourse(request, response);
                break;

            case "Add":
                redirectToAdd(request, response);
                break;
            default:
                getCourses(request, response);
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("courseId");

        Course course = new Course();
        course.setCourseName(request.getParameter("courseName"));
        course.setStatus(Integer.valueOf(request.getParameter("status")));
        course.setLecturerUserId(Integer.valueOf(request.getParameter("lecturerUserId")));

        if (lecturersList != null) {
            for (User lecturer : lecturersList) {
                if (lecturer.getId() == course.getLecturerUserId()) {
                    course.setLecturerName(lecturer.getFullName());
                }
            }
        }

        if (id == null || id.isEmpty()) {
            if (courseDao.add(course)) {
                request.setAttribute("NOTIFICATION", "Course Added Successfully!");
            }
        } else {
            course.setCourseId(Integer.parseInt(id));
            if (courseDao.update(course)) {
                request.setAttribute("NOTIFICATION", "Course Updated Successfully!");
            }
        }

        getCourses(request, response);
    }

    private void getCourses(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Course> coursesList = courseDao.get();
        request.setAttribute("coursesList", coursesList);
        requestDispatcher = request.getRequestDispatcher("/views/coursesManager.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getSingleCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        Course course = courseDao.getCourse(Integer.parseInt(id));

        request.setAttribute("course", course);

        lecturersList = userDao.getUsersByPrivilegeSchema(Constant.PRIVILEGE_SCHEMA_LECTURER);

        request.setAttribute("lecturersList", lecturersList);

        requestDispatcher = request.getRequestDispatcher("/views/courseInfo.jsp");

        requestDispatcher.forward(request, response);
    }

    private void redirectToAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        lecturersList = userDao.getUsersByPrivilegeSchema(Constant.PRIVILEGE_SCHEMA_LECTURER);

        request.setAttribute("lecturersList", lecturersList);

        requestDispatcher = request.getRequestDispatcher("/views/courseInfo.jsp");

        requestDispatcher.forward(request, response);
    }
}
