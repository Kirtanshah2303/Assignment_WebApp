<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
    <title>luv2code Company Home Page</title>
</head>


<h2>luv2code Company Home Page</h2>
<hr>

Welcome to the luv2code company home page!
<br/>
<hr>

<!-- display user name and role -->

<p>
    <sec:authorize access="isAuthenticated()">
    User: <security:authentication property="principal.name" />
    <br><br>
    Role(s): <security:authentication property="principal.authorities" />
    </sec:authorize>
</p>
<hr>
<p>
    <security:authorize access="hasRole('ADMIN')">
    <a href="${pageContext.request.contextPath}/admin">Admin</a>
    </security:authorize>
    <br/>
<%--    <security:authorize access="hasRole('GUEST')">--%>
    <security:authorize access="hasRole('USER')">
<%--    <a href="${pageContext.request.contextPath}/guest">Guest</a>--%>
        <form:form method="post" action="http://localhost:8080/uploadFile" enctype="multipart/form-data">
            <input type = "file" name = "file" size = "50" />
            <br />
            <input type="submit" value="File Upload"/>
        </form:form>
    </security:authorize>
</p>
<hr>
<form:form action="${pageContext.request.contextPath}/logout"
           method="POST">
    <input type="submit" value="logout"/>
</form:form>
</body>

</html>