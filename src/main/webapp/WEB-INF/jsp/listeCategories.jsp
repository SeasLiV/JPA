<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Gestion Catégories</title>
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
                <li><a href="ajouterTache">Ajouter une tâche</a></li>
                <li class="active"><a href="listerCategories">Catégories</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="bleu">Gestion des Catégories</h1>
    <br>
    <c:choose>
        <c:when test="${listeC.size() == 0}">
            <h3>Liste des carégories vide !</h3>
        </c:when>
        <c:otherwise>
            <table class="table table-hover table-striped">
                <c:forEach items="${listeC}" var="c" varStatus="bStatus">
                    <form action="modifCategorie" method="Post">
                        <tr>
                            <input type="hidden" name="id" value="${c.id}" />
                            <td>${c.id}</td>
                            <td><input type="text" name="libelle" value="${c.libelle}" /></td>
                            <td class="centre">
                                <button type="submit" class="glyphicon glyphicon-edit vert"></button>
                            </td>
                            <td class="centre">
                                <a href="supprimerCategorie?index=c${c.id}">
                                    <span class="glyphicon glyphicon-remove rouge" id="c${c.id}"></span>
                                </a>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
    <br><br><br>
    <h2 class="bleu">Nouvelle catégorie :</h2>
    <div>
        <form:form action="ajouterCategorie" method="POST"
                   cssClass="form-horizontal" commandName="cat">
            <div class="form-group">
                <div class="col-xs-8">
                    <form:input path="libelle" placeholder="Libellé de la catégorie ..."
                                cssClass="form-control" />
                </div>
                <div class="col-xs-2">
                    <form:errors path="libelle"
                                cssClass="error" />
                </div>
                <div class="col-xs-2">
                    <button type="submit" class="btn btn-primary pull-right">Envoyer</button>
                </div>
            </div>

        </form:form>
    </div>

</div>
</body>
</html>
