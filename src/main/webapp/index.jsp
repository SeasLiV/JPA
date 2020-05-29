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
            <a  href="index.jsp" class="navbar-brand active">
                <span class="glyphicon glyphicon-pencil"></span>
                <span class="glyphicon glyphicon-ok"></span>
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
                <li><a href="app/listerTaches">Liste des Tâches</a></li>
                <li><a href="app/ajouterTache">Ajouter une tâche</a></li>
                <li><a href="app/listerCategories">Catégories</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
