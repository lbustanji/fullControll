
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("loginId") == null) {
        response.sendRedirect("/StudentsManagementWebPortal/views/Login.jsp");
    }
%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#">
        <img src="https://1qjpt15fhlq3xjfpm2utibj1-wpengine.netdna-ssl.com/wp-content/themes/m30/images/m30-logo.png" alt="Logo" style="width:40px;">
    </a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link fas fa-book" <c:if test="${privilegeSchema eq '1330' or privilegeSchema eq '1331'}">hidden="true"</c:if> href="${pageContext.request.contextPath}/LecturerCoursesController"> Courses</a>
            </li>
            <li class="nav-item">
                <a class="nav-link fas fa-book" <c:if test="${privilegeSchema eq '1330' or privilegeSchema eq '1332'}">hidden="true"</c:if> href="${pageContext.request.contextPath}/StudentCoursesController"> Courses</a>
            </li>
            <li class="nav-item">
                <a class="nav-link fas fa-users" <c:if test="${privilegeSchema eq '1331' or privilegeSchema eq '1332'}">hidden="true"</c:if> href="${pageContext.request.contextPath}/UsersManagerController"> Users Manager</a>
            </li>
             <li class="nav-item">
                <a class="nav-link fas fa-book" <c:if test="${privilegeSchema eq '1331' or privilegeSchema eq '1332'}">hidden="true"</c:if> href="${pageContext.request.contextPath}/CoursesManagerController"> Courses Manager</a>
            </li>
            <li class="nav-item">
                <a class="nav-link fas fa-user-alt" href="${pageContext.request.contextPath}/UsersManagerController?action=EDIT&id=${userId}"> Profile</a>
        </li>

        <li class="nav-item">
            <a class="nav-link fas fa-sign-out-alt" href="${pageContext.request.contextPath}/views/Logout.jsp"> Logout</a>
        </li>
    </ul>
</nav> 
<br/>
<br/>
<br/>
