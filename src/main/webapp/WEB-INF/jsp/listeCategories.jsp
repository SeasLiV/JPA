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
<div class="container">
    <h1 class="bleu">Gestion des Catégories</h1>
    <br>
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
                            <span class="glyphicon glyphicon-remove rouge" id="s${c.id}"></span>
                        </a>
                    </td>
                </tr>
            </form>
        </c:forEach>
    </table>

    <br><br><br>
    <h2 class="bleu">Nouvelle catégorie :</h2>
    <div>
        <form:form action="ajouterCategorie" method="POST"
                   cssClass="form-horizontal" modelAttribute="cat">
            <div class="form-group">
                <div class="col-xs-10">
                    <form:input path="libelle" placeholder="Libellé de la catégorie ..."
                                cssClass="form-control" />
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
