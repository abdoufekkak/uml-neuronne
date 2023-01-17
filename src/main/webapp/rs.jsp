<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="q" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultat</title>
</head>
<body>
<form action="apprenti" method="get">
<table class="table">
		<thead class="thead-light">
			<tr>
				<th scope="col">#</th>
				<th scope="col">y00</th>
				<th scope="col">y10</th>
				<th scope="col">y20</th>
				<th scope="col">y3</th>
			</tr>
		</thead>
		<tbody>
		<%ArrayList<Double> x=(ArrayList<Double>) request.getAttribute("resultat") ;
		%>
		<tr>
				<th scope="row">#</th>
				<td>${x.get(0)}</td>
				<td>${x.get(1)}</td>
				<td>${x.get(2)} </td>
				<td>${x.get(3)}</td>
		</tr>
		</tbody>
	</table>
</form>
</body>
</html>