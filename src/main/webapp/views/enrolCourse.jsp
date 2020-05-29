<%-- 
    Document   : userInfo
    Created on : 16-May-2020, 16:28:32
    Author     : lbust
--%>

<%@page import="com.fullcontrol.studentsmanagementwebportal.classes.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Info</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    </head>
    <%@include  file="navBar.jsp"%> 
    <body>
        <div class="container">
            <div class = "row">
                <div class = "col-md-4">
                    <form action = "${pageContext.request.contextPath}/StudentCoursesController" method="POST">

                        <div class="form-group">
                            Course:
                            <select value="${course.courseId}" name="courseId" class="form-control">
                                <c:forEach items="${coursesList}" var="course">
                                    <option value="${course.courseId}">${course.courseName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <button type = "submit" class = "btn btn-primary">Save</button>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
