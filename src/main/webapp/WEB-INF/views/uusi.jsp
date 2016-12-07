<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Lisätyn Tietokoneen tiedot</title>

</head>
<body>
	<h1>uusi kone syötetty</h1>

	<p>${tietokone.merkki} ja ${tietokone.malli}</p>


	<p>
		<a href="<c:url value='/' />">Listaa koneet</a>
	</p>
</body>
</html>