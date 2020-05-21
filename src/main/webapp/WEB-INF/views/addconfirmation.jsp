<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Grade Add Confirmation</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<div>
<h1><b>Grade added</b></h1>
<p>The grade was added to the database.</p>
<h2>Details:</h2>
<p><b>Name:</b> <c:out value="${grade.name}" /></p>
<p><b>Type:</b> <c:out value="${grade.type}" /></p>
<p><b>Score:</b> <c:out value="${grade.score}" /></p>
<p><b>Total:</b> <c:out value="${grade.total}" /></p>
<a href="/">Return to grade list</a>
</div>
</body>
</html>