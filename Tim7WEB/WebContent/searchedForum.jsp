<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Forum ${forum.naziv} </title>
</head>
<body>
	
	<h2> Dobrodosli na temu ${forum.naziv} !</h2>
	
	<br>
	
	<b> Unesite svoj komentar na ovu temu: </b>
	
	<form action="/Tim7WEB/UnosKomentaraServlet" method="post">
		<table>
			<tr>
				<td> Komentar : </td>
				<td> <input type="text" name="objava"> </td>
				<td> <input type="submit" value="Unesite komentar"> </td>
			</tr>
		</table>
	</form>
	
	<br>
	
	<form action="/Tim7WEB/PrikazKomentaraServlet" method="post">
		<input type="submit" value="Prikazi trenutne komentare na temu ${forum.naziv} : " >
	</form>
	
	<table>
		<tr>
			<td> OBJAVA </td>
		</tr>
		
		<c:forEach items="${listaKomentara}" var="komentari">
			<tr>
				<td> ${komentari.objava} </td>
				<td>
					<img src="images/slika4.png" HEIGHT="100" BORDER="1">
				</td>
			</tr>
		</c:forEach>
	</table>
	
	${message}
</body>
</html>