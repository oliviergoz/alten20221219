<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body class="container">
	<nav>
		<a href="./produit" class="btn btn-link">produits</a> <a
			href="./fournisseur" class="btn btn-link">fournisseurs</a>
	</nav>
	<h1>liste des fournisseurs</h1>
	<table class="table">
		<tr>
			<th>id:</th>
			<th>nom:</th>
			<th>email:</th>
			<th>adresse:</th>
			<th>contact:</th>
			<th></th>
			<th><div class="alert alert-danger">attention on ne gere
					pas si il y a toujours des produits associer au
					fournisseur=>violation de contrainte</div></th>
		</tr>
		<c:forEach items="${fournisseurs}" var="f">
			<tr>
				<td>${f.id}</td>
				<td>${f.nom}</td>
				<td>${f.email}</td>
				<td>${f.adresse.numero}${f.adresse.rue}<br />${f.adresse.codePostal}
					${f.adresse.ville}
				</td>
				<td>${f.contact}</td>
				<td><a href="./fournisseur?q=edit&id=${f.id}"
					class="btn btn-outline-primary">editer</a></td>
				<td><a href="./fournisseur?q=delete&id=${f.id}"
					class="btn btn-outline-danger">supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="./fournisseur?q=add" class="btn btn-link">nouveau
		fournisseur</a>
</body>
</html>