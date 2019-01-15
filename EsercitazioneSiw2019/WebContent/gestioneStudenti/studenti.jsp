<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/common.css" type="text/css" />

</head>
<body>
	<header>
		<h1>Elenco Studenti</h1>
	</header>
	<table>
	<tr>
		<th>
			Matricola
		</th>
		<th>
			Nome
		</th>
		<th>
			Cognome
		</th>
	</tr>
	<c:forEach items="${studenti}" var="stud">
		<tr>
			<td>
				${stud.matricola}
			</td>
			<td>
				${stud.nome}
			</td>
			<td>
				${stud.cognome}
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>