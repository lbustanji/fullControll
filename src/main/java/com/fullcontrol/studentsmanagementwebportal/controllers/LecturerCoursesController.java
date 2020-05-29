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
@WebServlet(name = "LecturerCoursesController", urlPatterns = {"/LecturerCoursesController"})
public class LecturerCoursesController extends HttpServlet {

    CourseDao courseDao = null;
    UserDao userDao = null;
    RequestDispatcher requestDispatcher = null;
    List<User> lecturersList = null;

    public LecturerCoursesController() {
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

            case "INFO":
                getSingleCourse(request, response);
                break;
            case "STUDENT":
                getSingleStudent(request, response);
                break;
            default:
                getCourses(request, response);
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String courseId = request.getParameter("courseId");
        String studentUserId = request.getParameter("studentId");
        String firstExam = request.getParameter("firstExam");
        String secondExam = request.getParameter("secondExam");
        String finalExam = request.getParameter("finalExam");
        String attendance = request.getParameter("attendance");

        Course course = new Course();
        course.setCourseId(Integer.parseInt(courseId));
        course.setStudentUserId(Integer.parseInt(studentUserId));
        course.setFirstExamGrade(Integer.parseInt(firstExam));
        course.setSecondExamGrade(Integer.parseInt(secondExam));
        course.setFinalExamGrade(Integer.parseInt(finalExam));
        course.setAttendance(Integer.parseInt(attendance));
        if (courseDao.updateEnrolledCourseInfo(course)) {
            request.setAttribute("NOTIFICATION", "Course Updated Successfully!");
        }
        request.setAttribute("id", course.getCourseId());
        getSingleCourse(request, response);
    }

    private void getCourses(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");
        List<Course> coursesList = courseDao.getLecturerCourses(userId);
        request.setAttribute("coursesList", coursesList);
        requestDispatcher = request.getRequestDispatcher("/views/lecturerCourses.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getSingleCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseId = request.getParameter("id");
        if (courseId == null) {
            courseId = String.valueOf(request.getAttribute("id"));
        }
        List<Course> studentsList = courseDao.getLecturerStudents(Integer.parseInt(courseId));

        request.setAttribute("studentsList", studentsList);

        requestDispatcher = request.getRequestDispatcher("/views/courseStudentsList.jsp");

        requestDispatcher.forward(request, response);
    }

    private void getSingleStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = request.getParameter("studentUserId");
        String courseId = request.getParameter("courseId");

        List<Course> studentsList = courseDao.getLecturerStudents(Integer.parseInt(courseId));
        Course studentCourse = new Course();
        for (Course stuCourse : studentsList) {
            if (stuCourse.getStudentUserId() == Integer.valueOf(studentId)) {
                studentCourse = stuCourse;
            }

        }
        request.setAttribute("studentCourse", studentCourse);

        requestDispatcher = request.getRequestDispatcher("/views/studentCourseInfo.jsp");

        requestDispatcher.forward(request, response);
    }
}
