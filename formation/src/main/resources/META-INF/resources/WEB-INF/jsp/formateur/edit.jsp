<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<base href="${pageContext.request.contextPath}/">
</head>
<body>
	<div class="container">
		<nav>
			<a href="formateur" class="btn btn-link">fournisseurs</a>
		</nav>
		<h1>edition fournisseur</h1>
		<div class="card w-100">
			<div class="card-body">
				<form:form action="formateur/save" method="get"
					modelAttribute="formateur">
					<div class="form-group">
						<form:label path="id">id:</form:label>
						<form:input path="id" readonly="true"
							placeholder="generation automatique" cssClass="form-control" />
					</div>
					<div class="form-group">
						<form:label path="prenom">prenom:</form:label>
						<form:input path="prenom" cssClass="form-control" />
						<form:errors path="prenom" cssClass="alert alert-danger"
							element="div"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="nom">nom:</form:label>
						<form:input path="nom" cssClass="form-control" />
						<form:errors path="nom">
							<div class="alert alert-danger">mon message</div>
						</form:errors>
					</div>
					<div class="form-group">
						<form:label path="email">email:</form:label>
						<form:input type="email" path="email" cssClass="form-control" />
					</div>
					<div class="form-group">
						<form:label path="dtNaiss">date de naissance:</form:label>
						<form:input type="date" path="dtNaiss" cssClass="form-control" />
						<form:errors path="dtNaiss"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="cout">cout:</form:label>
						<form:input type="number" step="0.1" path="cout"
							cssClass="form-control" />
					</div>
					<div class="form-group">
						<form:label path="interne">interne:<form:checkbox
								path="interne" cssClass="form-check-input" />
						</form:label>
					</div>
					<div class="form-group">
						<form:label path="adresse.numero">numero:</form:label>
						<form:input path="adresse.numero" cssClass="form-control" />
					</div>
					<div class="form-group">
						<form:label path="adresse.rue">rue:</form:label>
						<form:input path="adresse.rue" cssClass="form-control" />
					</div>
					<div class="form-group">
						<form:label path="adresse.codePostal">code postal:</form:label>
						<form:input path="adresse.codePostal" cssClass="form-control" />
					</div>
					<div class="form-group">
						<form:label path="adresse.ville">ville:</form:label>
						<form:input path="adresse.ville" cssClass="form-control" />
					</div>
					<!--  <div>
						<form:select path="">
							<form:options items="${laListeATraiter}" itemLabel="leLabelQuiApparaitALecran=>attribut d'un objet de la liste" itemValue="attribut à mettre en value"/>
						</form:select>
				 -->
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="formateur" class="btn btn-outline-warning">annuler</a>
			</div>

			</form:form>
		</div>
	</div>
	</div>
</body>
</html>