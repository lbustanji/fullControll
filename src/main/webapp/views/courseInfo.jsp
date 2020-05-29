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
                    <form action = "${pageContext.request.contextPath}/CoursesManagerController" method="POST">
                        <div class="form-group">
                            <span class="badge badge-secondary">ID:</span> <span class="badge badge-primary">${course.courseId}</span>
                        </div>


                        <div class="form-group">
                            Course Name:<input type="text" name="courseName" class="form-control" value="${course.courseName}">
                        </div>

                        <div class="form-group">
                            Lecturer:
                            <select value="${course.lecturerUserId}" name="lecturerUserId" class="form-control">
                                <c:forEach items="${lecturersList}" var="lecturer">
                                    <option value="${lecturer.id}"
                                            <c:if test="${course.lecturerUserId eq lecturer.id}">selected="selected"</c:if>
                                            >${lecturer.fullName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            Status:
                            <select value="${course.status}" name="status" class="form-control">
                                <option ${course.status==1001?'selected=selected':''} value="1001">Active</option>
                                <option ${course.status==1002?'selected=selected':''} value="1002">Inactive</option>
                            </select>
                        </div>

                        <button type = "submit" class = "btn btn-primary">Save</button>
                        <input type="hidden" name="courseId" value="${course.courseId}">
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
