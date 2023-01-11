<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>formation</title>
</head>
<body class="container">
	<nav>
		<a href="formateur" class="btn btn-link">formateur</a> <a
			href="formation" class="btn btn-link">formation</a>
	</nav>
	<h1>liste des formateur</h1>
	<table class="table">
		<tr>
			<th>id:</th>
			<th>prenom:</th>
			<th>nom:</th>
			<th>email:</th>
			<th>date de naissance</th>
			<th>adresse:</th>
			<th>cout:</th>
			<th>interne:</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${page.getContent()}" var="f">
			<tr>
				<td>${f.id}</td>
				<td>${f.prenom}</td>
				<td>${f.nom}</td>
				<td>${f.email}</td>
				<td><fmt:parseDate value="${f.dtNaiss}"
						pattern="yyyy-MM-dd" var="pardeDate" type="date"></fmt:parseDate>
					<fmt:formatDate value="${pardeDate}" pattern="dd/MM/yyyy" />
				</td>
				<td>${f.adresse.numero}${f.adresse.rue}<br />${f.adresse.codePostal}
					${f.adresse.ville}
				</td>
				<td>${f.cout}</td>
				<td><c:choose>
						<c:when test="${f.interne == true }">
							<input type="radio" checked="checked" readonly="readonly">
						</c:when>
						<c:otherwise>
							<input type="radio" readonly="readonly">
						</c:otherwise>
					</c:choose></td>
				<td><a href="./formateur/edit?id=${f.id}"
					class="btn btn-outline-primary">editer</a></td>
				<td><a href="./formateur/delete?id=${f.id}"
					class="btn btn-outline-danger">supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="./formateur/add" class="btn btn-link">nouveau formateur</a>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="./formateur?page=${page.previousOrFirstPageable().getPageNumber()}">Previous</a></li>

			<li class="page-item"><a class="page-link"
				href="./formateur?page=${page.nextOrLastPageable().getPageNumber()}">Next</a></li>
		</ul>
	</nav>
</body>
</html>