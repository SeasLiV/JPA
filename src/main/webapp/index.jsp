<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TODOS</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="index.jsp" class="navbar-brand active">
                <span class="glyphicon glyphicon-film"></span>
                <span class="glyphicon glyphicon-film"></span>
            </a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="#">Accueil</a></li>
                <li><a href="app/lister">Liste des films</a></li>
                <li><a href="app/ajouter">Ajouter un film</a></li>
                <li><a href="app/listerStyle">Styles</a></li>
                <li><a href="geo.jsp">Qui sommes-nous</a></li>
                <li><a href="login.jsp">LOGIN</a></li>
            </ul>
        </div>
    </div>
</nav>
<p><a href="app/login"></a>Lien vers app/login</p>
</body>
</html>
