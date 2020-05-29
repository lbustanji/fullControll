/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.classes;

/**
 *
 * @author lbust
 */
public class Course {

    private int courseId;
    private int lecturerUserId;
    private int studentUserId;
    private int status;
    private int firstExamGrade;
    private int secondExamGrade;
    private int finalExamGrade;
    private int attendance;
    private String lecturerName;
    private String studentName;
    private String courseName;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getLecturerUserId() {
        return lecturerUserId;
    }

    public void setLecturerUserId(int lecturerUserId) {
        this.lecturerUserId = lecturerUserId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFirstExamGrade() {
        return firstExamGrade;
    }

    public void setFirstExamGrade(int firstExamGrade) {
        this.firstExamGrade = firstExamGrade;
    }

    public int getSecondExamGrade() {
        return secondExamGrade;
    }

    public void setSecondExamGrade(int secondExamGrade) {
        this.secondExamGrade = secondExamGrade;
    }

    public int getFinalExamGrade() {
        return finalExamGrade;
    }

    public void setFinalExamGrade(int finalExamGrade) {
        this.finalExamGrade = finalExamGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(int studentUserId) {
        this.studentUserId = studentUserId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


}
