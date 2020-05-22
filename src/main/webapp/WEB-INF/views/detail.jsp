<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Grades</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page='navbar.jsp'></jsp:include>
	<div class="container">
		<h1>Grade Details</h1>
		<table class="table">
			<tr>
				<th scope="row">Name</th>
				<td><c:out value="${grade.name}" /></td>
			</tr>
			<tr>
				<th scope="row">Type</th>
				<td><c:out value="${grade.type}" /></td>
			</tr>
			<tr>
				<th scope="row">Score</th>
				<td><c:out value="${grade.score}" /></td>
			</tr>
			<tr>
				<th scope="row">Total</th>
				<td><c:out value="${grade.total}" /></td>
			</tr>
		</table>
		<a class="btn btn-danger"
			href="/grades/deleteconfirmation?id=${grade.id}">Delete</a> <a
			class="btn btn-light" href="/">Cancel</a>
	</div>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>