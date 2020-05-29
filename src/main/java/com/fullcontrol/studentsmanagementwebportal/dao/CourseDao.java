/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.dao;

import com.fullcontrol.studentsmanagementwebportal.classes.Course;
import java.util.List;

/**
 *
 * @author lbust
 */
public interface CourseDao {

    List<Course> get();

    List<Course> getLecturerCourses(int lecturerUserId);

    List<Course> getLecturerStudents(int courseId);

    Course getCourse(int id);

    boolean update(Course course);

    boolean updateEnrolledCourseInfo(Course course);

    boolean add(Course course);

    List<Course> getEnrolledCourses(int studentUserId);

    boolean enrollCourse(int courseId, int userId);
}
