<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Grade Delete Confirmation</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<h1><b>Delete <c:out value="${grade.name}?"/></b></h1>
<p>Are you sure you want to delete this grade?</p>
<p><i><c:out value="${grade.name}"/></i></p>
<a class="btn btn-light" href="/">Cancel</a> | <a class="btn btn-danger" href="/grades/delete?id=${grade.id}">Delete</a>

</body>
</html>