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
			<a href="./produit" class="btn btn-link">produits</a> <a
				href="./fournisseur" class="btn btn-link">fournisseurs</a>
		</nav>
		<h1>creation produit</h1>
		<div class="card w-100">
			<div class="card-body">
				<form action="./produit" method="post">
					<input type="hidden" name="q" value="save">
					<c:if test="${ produit.id !=null }">
						<div class="form-group">
							<label for="id">id:</label> <input id="id" name="id"
								class="form-control" value="${produit.id}" readonly
								placeholder="generation automatique">
						</div>
						<input type="hidden" name="version" value="${produit.version}">
					</c:if>
					<div class="form-group">
						<label for="libelle">libelle:</label> <input id="libelle"
							name="libelle" class="form-control" value="${produit.libelle}">
					</div>
					<div class="form-group">
						<label for="description">description:</label>
						<textarea rows="10" name="description" id="description"
							class="form-control">${produit.description }</textarea>
					</div>
					<div class="form-group">
						<label for="prix">prix:</label> <input type="number" step="0.1"
							id="prix" name="prix" class="form-control"
							value="${produit.prix}">
					</div>
					<div>
						<label for="fournisseur.id">fournisseur:</label> <select
							id="fournisseur.id" name="fournisseur.id" class="form-control">
							<c:forEach items="${fournisseurs}" var="f">
								<c:choose>
									<c:when test="${produit.fournisseur.id == f.id }">
										<option value="${f.id}" selected="selected">${f.nom}</option>
									</c:when>
									<c:otherwise>
										<option value="${f.id}">${f.nom}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-outline-primary">enregistrer</button>
						<a href="./produit" class="btn btn-outline-warning">annuler</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>