<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
<h1>Login form1</h1>
<div>
    <form:form action="app/loginCheck" method="POST">
        <div>
            <form:label path="idConnexion">idConnexion : </form:label>
            <form:input path="idConnexion"/>
        </div>
        <div>
            <form:label path="password">password : </form:label>
            <form:input path="password"/>
        </div>
        <div>
            <input type="submit" value="GO"/>
        </div>
    </form:form>
</div>
</body>
</html>