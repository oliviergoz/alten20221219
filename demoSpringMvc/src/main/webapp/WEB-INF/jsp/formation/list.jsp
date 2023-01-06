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
<base href="${pageContext.request.contextPath}/">
<title>formation</title>
</head>
<body class="container">
	<nav>
		<a href="formateur" class="btn btn-link">formateur</a> <a
			href="formation" class="btn btn-link">formation</a>
	</nav>
	<h1>liste des formations</h1>
	<table class="table">
		<tr>
			<th>id:</th>
			<th>libellé:</th>
			<th>description:</th>
			<th>referent:</th>
			<th>distancielle:</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${page.getContent()}" var="f">
			<tr>
				<td>${f.id}</td>
				<td>${f.libelle}</td>
				<td><c:choose>
						<c:when test="${f.description.length()<30}"> ${f.description}</c:when>
						<c:otherwise>${f.description.substring(0,30)}...</c:otherwise>
					</c:choose></td>
				<td>${f.referent.prenom}&nbsp;${f.referent.nom }</td>
				<td><c:choose>
						<c:when test="${f.distanciel == true }">
							<input type="radio" checked="checked" readonly="readonly">
						</c:when>
						<c:otherwise>
							<input type="radio" readonly="readonly">
						</c:otherwise>
					</c:choose></td>
				<td><a href="./formation/edit?id=${f.id}"
					class="btn btn-outline-primary">editer</a></td>
				<td><a href="./formation/delete?id=${f.id}"
					class="btn btn-outline-danger">supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="./formation/add" class="btn btn-link">nouvelle formation</a>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="./formation?page=${page.previousOrFirstPageable().getPageNumber()}">precedent</a></li>

			<li class="page-item"><a class="page-link"
				href="./formation?page=${page.nextOrLastPageable().getPageNumber()}">suivant</a></li>
		</ul>
	</nav>
</body>
</html>