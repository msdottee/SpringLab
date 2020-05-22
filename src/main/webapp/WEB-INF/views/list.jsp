<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Grades</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Grades</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th><th>Type</th><th>Score</th><th>Total</th><th>Percentage</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="grade" items="${grades}">
				<tr>
					<td><a href="/grades/detail?id=${grade.id}"><c:out value="${grade.name}" /></a></td>
					<td><c:out value="${grade.type}" /></td>
					<td><c:out value="${grade.score}" /></td>
					<td><c:out value="${grade.total}" /></td>
					<td><c:out value="${grade.percentage}%" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/grades/add" class="btn btn-dark">Add Grade</a>
	</div>
</body>
</html>