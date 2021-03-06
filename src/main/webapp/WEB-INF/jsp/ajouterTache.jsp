<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Ajouter Tâche</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-default">
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
                    <li><a href="index.jsp">Accueil</a></li>
                    <li><a href="listerTaches">Liste des Tâches</a></li>
                    <li class="active"><a href="ajouterTache">Ajouter une tâche</a></li>
                    <li><a href="listerCategories">Catégories</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <h1 class="bleu">Ajout d'une tâche</h1>
        <br><br>
        <div>
            <form:form action="ajouterValid" method="POST" cssClass="form-horizontal" modelAttribute="tache">
                <div class="form-group">
                    <form:label path="date" cssClass="col-xs-2 control-label">Date :</form:label>
                    <div class="col-xs-10">
                        <form:input path="date" cssClass="form-control" />
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="description" cssClass="col-xs-2 control-label">Description :</form:label>
                    <div class="col-xs-10">
                        <form:input path="description"  placeholder="Description ..."  cssClass="form-control" />
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="categories" cssClass="col-xs-2 control-label">Categories :</form:label>
                    <div class="col-xs-10">
                        <form:checkboxes path="categories" items="${listeCategories}" itemValue="id" itemLabel="libelle"/>
                    </div>
                </div>

                <div class="form-group" >
                    <div class="col-xs-offset-2 col-xs-10">
                        <button type="submit" class="btn btn-primary">Envoyer</button>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</body>
</html>
