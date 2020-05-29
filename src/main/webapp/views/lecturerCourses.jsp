<%-- 
    Document   : usersManager
    Created on : 15-May-2020, 18:36:51
    Author     : lbust
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses Management</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    </head>
    <%@include  file="navBar.jsp"%> 
    <body>
        <div class="container">
            <table class="table table-striped table-bordered">
                <tr class="thead-dark">
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${coursesList}" var="course">

                    <tr>
                        <td>${course.courseId}</td>
                        <td>${course.courseName}</td>
                        <td>${course.status==1001?'Active':'Inactive'}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/LecturerCoursesController?action=INFO&id=${course.courseId}">View</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
