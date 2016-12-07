<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Tietokoneen tiedot</title>

</head>
<body>
	<h1>Tietokoneet listattuna JPA-tietokannasta</h1>
	<c:forEach var="tietokone" items="${tietokoneet}">
		<p>${tietokone.merkki} ja ${tietokone.malli}</p>
	</c:forEach>

	<p>
		<a href="lomake">Syötä uusi</a>
</body>
</html>