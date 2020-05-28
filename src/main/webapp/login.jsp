<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
    <input name="pseudo" class="form-control" placeholder="pseudo" type="text">
    <input name="MotDePasse" class="form-control" placeholder="******"
           type="password">

    <button type="submit" class="btn btn-primary">
        Valider
    </button>
</form>
</body>
</html>
