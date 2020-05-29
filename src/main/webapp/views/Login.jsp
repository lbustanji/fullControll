<%-- 
    Document   : Login
    Created on : 15-May-2020, 12:09:51
    Author     : lbust
--%>

<%@page import="com.fullcontrol.studentsmanagementwebportal.util.Constant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">-->
        <!--<link href="../bootstrap/css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            if (session.getAttribute("loginId") != null) {
                response.sendRedirect("/StudentsManagementWebPortal/UsersManagerController");
            }
        %>
        <section class="container-fluid" style="
                 background: url('https://illinois-state-cdn.imgix.net/web/homepage-main/2020/visit-may-2020.jpg') no-repeat;
                 /*background: url('images/castle.jpg') no-repeat;*/
                 width: 100%;
                 height: 100vh;
                 background-size: 100%">
            <% if (request.getParameter("status") != null) { %>
            <div class="alert alert-danger alert-dismissible fade show">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Error!</strong>Enter Valid Login Id And Password 
            </div>
            <% }%>
            <section class="row justify-content-center" style="position: relative;top: 15vh">
                <section class="col-12 col-sm-6 col-md-3">
                    <form action="${pageContext.request.contextPath}/LoginController" method="post" style="box-shadow: 0px 0px 10px 0px;
                          border-radius: 10px">

                        <div class="card">
                            <div class="card-header">
                                Login
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Login Id</label>
                                    <input type="text" name="LoginId" class="form-control" placeholder="Enter Login Id"/>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" name="Password" class="form-control" placeholder="Enter Password"/>
                                </div>
                            </div>
                            <div class="card-footer">
                                <input type="submit" value="Login" class="btn btn-primary btn-block"/><br/>

                                don't have an account? <a href="/StudentsManagementWebPortal/views/RegisterUser.jsp" >Sign Up</a>
                            </div>
                        </div>
                    </form>
                </section>
            </section>
        </section>

    </body>
</html>
