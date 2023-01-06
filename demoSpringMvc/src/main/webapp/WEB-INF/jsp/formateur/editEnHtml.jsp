<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
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
</head>
<body>
	<div class="container">
		<nav>
			<a href="./formateur" class="btn btn-link">fournisseurs</a>
		</nav>
		<h1>edition fournisseur</h1>
		<div class="card w-100">
			<div class="card-body">
				<form action="../formateur" method="post">
					<div class="form-group">
						<label for="id">id:</label> <input id="id" name="id"
							class="form-control" value="${formateur.id}" readonly
							placeholder="generation automatique">
					</div>
					<div class="form-group">
						<label for="prenom">prenom:</label> <input id="prenom"
							name="prenom" class="form-control" value="${formateur.prenom}">
					</div>
					<div class="form-group">
						<label for="nom">nom:</label> <input id="nom" name="nom"
							class="form-control" value="${formateur.nom}">
					</div>
					<div class="form-group">
						<label for="email">email:</label> <input type="email" id="email"
							name="email" class="form-control" value="${formateur.email}">
					</div>
					<div class="form-group">
						<label for="cout">cout:</label> <input type="number" id="cout"
							step="0.1" name="cout" class="form-control"
							value="${formateur.cout}">
					</div>

					<div class="form-group">
						<label for="adresse.numero">numero:</label> <input
							id="adresse.numero" name="adresse.numero" class="form-control"
							value="${formateur.adresse.numero}">
					</div>
					<div class="form-group">
						<label for="adresse.rue">rue:</label> <input id="adresse.rue"
							name="adresse.rue" class="form-control"
							value="${formateur.adresse.rue}">
					</div>
					<div class="form-group">
						<label for="adresse.codePostal">code postal:</label> <input
							id="adresse.codePostal" name="adresse.codePostal"
							class="form-control" value="${formateur.adresse.codePostal}">
					</div>
					<div class="form-group">
						<label for="adresse.ville">ville:</label> <input
							id="adresse.ville" name="adresse.ville" class="form-control"
							value="${formateur.adresse.ville}">
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-outline-primary">enregistrer</button>
						<a href="../formateur" class="btn btn-outline-warning">annuler</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>