/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.dao;

import com.fullcontrol.studentsmanagementwebportal.classes.Course;
import com.fullcontrol.studentsmanagementwebportal.controllers.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbust
 */
public class CourseDaoImpl implements CourseDao {

    List<Course> coursesList = null;
    Course course = null;

    @Override
    public List<Course> get() {
        String sql = "SELECT * FROM students_managment.courses";
        coursesList = new ArrayList();
        try {
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                course = new Course();
                course.setCourseId(rs.getInt("course_Id"));
                course.setStatus(rs.getInt("status"));
                course.setCourseName(rs.getString("course_Name"));
                course.setLecturerName(rs.getString("lecturer_Full_Name"));
                course.setLecturerUserId(rs.getInt("lecturer_User_Id"));
                coursesList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coursesList;
    }

    @Override
    public Course getCourse(int id) {
        Course course = null;
        try {
            course = new Course();
            String sql = "SELECT * FROM students_managment.courses where course_Id=" + id;
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                course.setCourseId(resultSet.getInt("course_Id"));
                course.setStatus(resultSet.getInt("status"));
                course.setCourseName(resultSet.getString("course_Name"));
                course.setLecturerName(resultSet.getString("lecturer_Full_Name"));
                course.setLecturerUserId(resultSet.getInt("lecturer_User_Id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public boolean update(Course course) {
        boolean flag = false;
        try {
            String sql = "UPDATE students_managment.courses SET course_Name = '" + course.getCourseName() + "', "
                    + "status = '" + course.getStatus()
                    + "', lecturer_User_Id = '" + course.getLecturerUserId()
                    + "', lecturer_Full_Name = '" + course.getLecturerName()
                    + "' where course_Id=" + course.getCourseId();
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateEnrolledCourseInfo(Course course) {
        boolean flag = false;
        try {
            String sql = "UPDATE students_managment.enrolledcourses SET First_Exam_Grade = '" + course.getFirstExamGrade() + "', "
                    + "Second_Exam_Grade = '" + course.getSecondExamGrade()
                    + "', Final_Exam_Grade = '" + course.getFinalExamGrade()
                    + "', Attendance = '" + course.getAttendance()
                    + "' where courseId=" + course.getCourseId()
                    + " and User_Id=" + course.getStudentUserId();
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean add(Course course) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO students_managment.courses (course_Id, course_Name, lecturer_User_Id, lecturer_Full_Name, status) VALUES ("
                    + "'0','"
                    + course.getCourseName() + "' , '"
                    + course.getLecturerUserId() + "' , '"
                    + course.getLecturerName() + "' , '"
                    + course.getStatus() + "')";
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Course> getEnrolledCourses(int studentUserId) {
        String sql = "SELECT * FROM students_managment.enrolledcourses inner Join students_managment.courses on students_managment.enrolledcourses.courseId=students_managment.courses.course_Id where students_managment.enrolledcourses.User_Id=" + studentUserId;
        coursesList = new ArrayList();
        try {
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                course = new Course();
                course.setCourseId(rs.getInt("course_Id"));
                course.setStatus(rs.getInt("status"));
                course.setCourseName(rs.getString("course_Name"));
                course.setLecturerName(rs.getString("lecturer_Full_Name"));
                course.setLecturerUserId(rs.getInt("lecturer_User_Id"));
                course.setFirstExamGrade(rs.getInt("First_Exam_Grade"));
                course.setSecondExamGrade(rs.getInt("Second_Exam_Grade"));
                course.setFinalExamGrade(rs.getInt("Final_Exam_Grade"));
                course.setAttendance(rs.getInt("Attendance"));
                coursesList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coursesList;
    }

    @Override
    public boolean enrollCourse(int courseId, int userId) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO students_managment.enrolledcourses (courseId, User_Id) VALUES ('"
                    + courseId + "' , '"
                    + userId
                    + "')";
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Course> getLecturerCourses(int lecturerUserId) {
        String sql = "SELECT * FROM students_managment.courses where lecturer_User_Id=" + lecturerUserId;
        coursesList = new ArrayList();
        try {
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                course = new Course();
                course.setCourseId(rs.getInt("course_Id"));
                course.setStatus(rs.getInt("status"));
                course.setCourseName(rs.getString("course_Name"));
                course.setLecturerName(rs.getString("lecturer_Full_Name"));
                course.setLecturerUserId(rs.getInt("lecturer_User_Id"));
                coursesList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coursesList;
    }

    @Override
    public List<Course> getLecturerStudents(int courseId) {
        String sql = "SELECT students_managment.enrolledcourses.courseId,"
                + "students_managment.courses.course_Name,"
                + "students_managment.enrolledcourses.User_Id,"
                + "students_managment.users.fullName,"
                + "students_managment.enrolledcourses.First_Exam_Grade,"
                + "students_managment.enrolledcourses.Second_Exam_Grade,"
                + "students_managment.enrolledcourses.Final_Exam_Grade,"
                + "students_managment.enrolledcourses.Attendance"
                + " FROM students_managment.enrolledcourses"
                + " inner Join students_managment.courses"
                + " on students_managment.enrolledcourses.courseId=students_managment.courses.course_Id"
                + " inner Join students_managment.users"
                + " on students_managment.enrolledcourses.User_Id=students_managment.users.User_Id"
                + " where students_managment.enrolledcourses.courseId=" + courseId;
        coursesList = new ArrayList();
        try {
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setCourseName(rs.getString("course_Name"));
                course.setStudentUserId(rs.getInt("User_Id"));
                course.setStudentName(rs.getString("fullName"));
                course.setFirstExamGrade(rs.getInt("First_Exam_Grade"));
                course.setSecondExamGrade(rs.getInt("Second_Exam_Grade"));
                course.setFinalExamGrade(rs.getInt("Final_Exam_Grade"));
                course.setAttendance(rs.getInt("Attendance"));
                coursesList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coursesList;
    }
}
