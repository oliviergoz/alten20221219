<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formation</title>
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
			<a href="formateur" class="btn btn-link">formateur</a> <a
				href="formation" class="btn btn-link">formation</a>
		</nav>
		<h1>edition formation</h1>
		<div class="card w-100">
			<div class="card-body">
				<form:form action="formation" method="post"
					modelAttribute="formation">
					<div class="form-group">
						<form:label path="id">id:</form:label>
						<form:input path="id" readonly="true"
							placeholder="generation automatique" cssClass="form-control" />
					</div>
					<div class="form-group">
						<form:label path="libelle">libelle:</form:label>
						<form:input path="libelle" cssClass="form-control" />
						<form:errors path="libelle" cssClass="alert alert-danger"
							element="div"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="description">description:</form:label>
						<form:textarea path="description" cssClass="form-control" />
						<form:errors path="description">
						</form:errors>
					</div>
					<div class="form-group">
						<form:label path="referent.id">referent</form:label>
						<form:select path="referent.id" cssClass="form-control">
							<form:options items="${formateurs}" itemLabel="infos"
								itemValue="id" />
						</form:select>
					</div>
					<div class="form-group">
						<form:label path="distanciel">distanciel:<form:checkbox
								path="distanciel" cssClass="form-check-input" />
						</form:label>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-outline-primary">enregistrer</button>
						<a href="formation" class="btn btn-outline-warning">annuler</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>