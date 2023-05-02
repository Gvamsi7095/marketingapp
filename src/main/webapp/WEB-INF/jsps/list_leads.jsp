<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All leads</title>
</head>
<body>
<table>
	<tr>
	<th>firstName</th>
	<th>LastName</th>
	<th>email</th>
	<th>mobile</th>
	<th>delete</th>
	<th>update</th>
	</tr>
	<c:forEach var="lead" items="${leads}">
	<tr>
		    <td>${lead.firstName}</td>
			<td>${lead.lastName}</td>
			<td>${lead.email}</td>
			<td>${lead.mobile}</td>

			<td><a href="delete?id=${lead.id}">delete</a></td>
			<td><a href="update?id=${lead.id}">update</a></td>
			
			
	</tr>
	</c:forEach>

</table>


</body>
</html>
