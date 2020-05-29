<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des tâches</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="index.jsp" class="navbar-brand active">
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
                <li class="active"><a href="listerTaches">Liste des Tâches</a></li>
                <li><a href="ajouterTache">Ajouter une tâche</a></li>
                <li><a href="listerCategories">Catégories</a></li>
            </ul>
        </div>
    </div>
</nav>
<p>${loggedUser}</p>
<div class="container">
    <h1 class="bleu">Liste des Tâches</h1>
    <br><br>
    <table class="table table-hover table-striped">
        <!-- TODO: recherche par date et categorie cf TP6 -->
        <tr>
            <th><a href="trier?par=DateAsc"><span class="glyphicon glyphicon-menu-down"></span></a> Date <a
                    href="trier?par=DateDesc"><span class="glyphicon glyphicon-menu-up"></span></a></th>
            <th><a href="trier?par=aA"><span class="glyphicon glyphicon-menu-down"></span></a> Description <a
                    href="trier?par=aD"><span class="glyphicon glyphicon-menu-up"></a></th>
            <th><a href="trier?par=sA"><span class="glyphicon glyphicon-menu-down"></span></a> Catégories <a
                    href="trier?par=sD"><span class="glyphicon glyphicon-menu-up"></a></th>
            <th><a href="trier?par=rA"><span class="glyphicon glyphicon-menu-down"></span></a> Etat <a
                    href="trier?par=rD"><span class="glyphicon glyphicon-menu-up"></a></th>
            <th>Actions</th>
        </tr>
        <c:choose>
            <c:when test="${listeT.size() == 0}">
                <h3>Pas de tâche créée</h3>
            </c:when>
            <c:otherwise>
                <c:forEach items="${listeT}" var="t" varStatus="bStatus">
                    <tr>
                        <td>${t.date}</td>
                        <td>${t.description}</td>
                        <td>
                            <c:forEach items="${t.categories}" var="c">
                                ${c.libelle}
                            </c:forEach>
                        </td>
                        <td>${t.etat?"Fait":"A faire"}</td>
                        <td class>
                            <a href="changerEtat?index=t${t.id}">
                                <span class="glyphicon glyphicon-edit" id="t${t.id}"></span>
                            </a>
                            <a href="supprimerTache?index=t${t.id}">
                                <span class="glyphicon glyphicon-remove rouge" id="t${t.id}"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
</div>
</body>
</html>
