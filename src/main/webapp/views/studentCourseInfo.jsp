<%-- 
    Document   : userInfo
    Created on : 16-May-2020, 16:28:32
    Author     : lbust
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Info</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    </head>
    <%@include  file="navBar.jsp"%> 
    <body>
        <div class="container">
            <div class = "row">
                <div class = "col-md-4">
                    <form action = "${pageContext.request.contextPath}/LecturerCoursesController" method="POST">
                        <div class="form-group">
                            Course Name:<input type="text" name="courseName" class="form-control" disabled="true" value="${studentCourse.courseName}">
                        </div>

                        <div class="form-group">
                            Student Name:<input type="text" name="studentName" class="form-control" disabled="true" value="${studentCourse.studentName}">
                        </div>

                        <div class="form-group">
                            First Exam:<input type="number" name="firstExam" class="form-control"  value="${studentCourse.firstExamGrade}">
                        </div>

                        <div class="form-group">
                            Second Exam:<input type="number" name="secondExam" class="form-control"  value="${studentCourse.secondExamGrade}">
                        </div>

                        <div class="form-group">
                            Final Exam:<input type="number" name="finalExam" class="form-control"  value="${studentCourse.finalExamGrade}">
                        </div>

                        <div class="form-group">
                            Attendance:<input type="number" name="attendance" class="form-control"  value="${studentCourse.attendance}">
                        </div>

                        <button type = "submit" class = "btn btn-primary">Save</button>
                        <input type="hidden" name="courseId" value="${studentCourse.courseId}">
                        <input type="hidden" name="studentId" value="${studentCourse.studentUserId}">
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
