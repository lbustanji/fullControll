<%-- 
    Document   : userInfo
    Created on : 16-May-2020, 16:28:32
    Author     : lbust
--%>

<%@page import="com.fullcontrol.studentsmanagementwebportal.classes.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <form action = "${pageContext.request.contextPath}/UsersManagerController" method="POST">
                        <div class="form-group">
                            <span class="badge badge-secondary">ID:</span> <span class="badge badge-primary">${user.id}</span>
                        </div>

                        <div class="form-group">
                            <span class="badge badge-secondary">Login ID:</span> <span class="badge badge-primary">${user.loginId}</span>
                        </div>

                        <div class="form-group">
                            Email:<input type="text" name="email" class="form-control" value="${user.email}">
                        </div>

                        <div class="form-group">
                            Status:
                            <select value="${user.status}" name="status" class="form-control">
                                <option ${user.status==1001?'selected=selected':''} value="1001">Active</option>
                                <option ${user.status==1002?'selected=selected':''} value="1002">Inactive</option>
                            </select>
                        </div>

                        <div class="form-group">
                            Privilege Schema:
                            <select value="${user.privilegeSchema}" name="privilegeSchema" class="form-control">
                                <option ${user.privilegeSchema==1330?'selected=selected':''} value="1330">Admin</option>
                                <option ${user.privilegeSchema==1331?'selected=selected':''} value="1331">Student</option>
                                <option ${user.privilegeSchema==1332?'selected=selected':''} value="1332">Lecturer</option>
                            </select>
                        </div>
                        <button type = "submit" class = "btn btn-primary">Save</button>
                        <input type="hidden" name="userId" value="${user.id}">
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
