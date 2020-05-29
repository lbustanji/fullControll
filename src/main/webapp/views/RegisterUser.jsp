<%-- 
    Document   : Login
    Created on : 15-May-2020, 12:09:51
    Author     : lbust
--%>

<%@page import="com.fullcontrol.studentsmanagementwebportal.util.Constant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Sign Up </title>
        <!--<link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">-->
        <!--<link href="../bootstrap/css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <section class="container-fluid" style="
                 background: url('https://illinois-state-cdn.imgix.net/web/homepage-main/2020/visit-may-2020.jpg') no-repeat;
                 /*background: url('images/castle.jpg') no-repeat;*/
                 width: 100%;
                 height: 100vh;
                 background-size: 100%">
            <section class="row justify-content-center" style="position: relative;top: 15vh">
                <section class="col-12 col-sm-6 col-md-3">
                    <form action="${pageContext.request.contextPath}/RegisterUserController" method="post" style="box-shadow: 0px 0px 10px 0px;
                          border-radius: 10px">
                        <div class="card">
                            <div class="card-header">
                                Sign Up 
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Full Name</label>
                                    <input type="text" name="fullName" class="form-control" placeholder="Enter Your Name"/>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" name="email" class="form-control" placeholder="Enter Your Email"/>
                                </div>
                                <div class="form-group">
                                    Privilege Schema:
                                    <select  name="privilegeSchema" class="form-control">
                                        <option  value="1330">Admin</option>
                                        <option selected="selected"  value="1331">Student</option>
                                        <option  value="1332">Lecturer</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Login Id</label>
                                    <input type="text" name="loginId" class="form-control" placeholder="Enter Login Id"/>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" name="password" class="form-control" placeholder="Enter Password"/>
                                </div>
                                <div class="form-group">
                                    <label>Confirm Password</label>
                                    <input type="password" name="confirmPassword" class="form-control" placeholder="Enter Password"/>
                                </div>
                            </div>
                            <div class="card-footer">
                                <input type="submit" value="Sign Up" class="btn btn-primary btn-block"/><br/>
                            </div>
                        </div>
                    </form>
                </section>
            </section>
        </section>

    </body>
</html>
