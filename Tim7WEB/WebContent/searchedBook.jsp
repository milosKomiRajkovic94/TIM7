<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trazena knjiga</title>
</head>
<body>
	<h2>Detalji o odabranoj knjizi su:</h2>
	<table>
		<tr>
			<td>Naslov knjige:</td>
			<td>${knj.naslov}</td>
		</tr>
		<tr>
			<td>Autor knjige:</td>
			<td>${knj.autor}</td>
		</tr>
		<tr>
			<td>Oblast knjige:</td>
			<td>${knj.oblast}</td>
		</tr>
		<tr>
			<td>Opis:</td>
			<td>${knj.opis}</td>
		</tr>
		<tr>
			<td>Bestseller:</td>
			<td>${knj.bestseller}</td>
		</tr>
		<tr>
			<td><img
				src="${pageContext.servletContext.contextPath }/Tim7WEB/SearchForBooksServletPicture?id=${knj.idknjiga}"
				HEIGHT="20" WIDTH="20" BORDER="0" /></td>
		</tr>
	</table>

	<br>
	<h2>Unesite dodatne podatke o knjizi:</h2>

	<form action="/Tim7WEB/UnosDodatnihPodatakaServlet" method="post">
		<table>
			<tr>
				<td>Cena:</td>
				<td><input type="text" name="cena"></td>
				<td>RSD</td>
			</tr>
			<tr>
				<td>Mesto gde se moze kupiti po toj ceni:</td>
				<td><input type="text" name="mesto"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Unos dodatnih podataka">
			</tr>
		</table>
	</form>

	${messageTwo}

	<br>
	<form action="/Tim7WEB/VratiSveDodatneInformacijeServlet" method="post">
		<input type="submit" value="Vrati sve dodatne informacije o knjizi">
	</form>

	<br>
	<table border="1">
		<tr>
			<td>CENA:</td>
			<td>MESTO:</td>
		</tr>
		<c:forEach items="${listaDodatnihInformacija}" var="info">
			<tr>
				<td>${info.cena}</td>
				<td>${info.lokacija}</td>
			</tr>
		</c:forEach>
	</table>

	<h2>Unesite svoj utisak o knjizi:</h2>

	<form action="/Tim7WEB/UnosUtiskaServlet" method="post">
		<table>
			<tr>
				<td><input type="text" name="utisak" size="35"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Unos utiska"></td>
			</tr>
		</table>
	</form>

	${message}

	<br>
	<form action="/Tim7WEB/VratiUtiskeServlet" method="post">
		<input type="submit" value="Prikazi sve utiske!" name="button">
	</form>

	<table border="1">
		<c:forEach items="${listaUtisaka}" var="utisak">
			<tr>
				<td>${utisak.utisak}</td>
				<td> <img src="images/slika4.png" HEIGHT="100" BORDER="1"> </td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<table>
		<tr>
			<td>
				<form action="searchForBooks.jsp">
					<button type="submit"><- Povratak na pretragu knjiga!</button>
				</form>
				<form action="LogOutServlet" method="post">
					<input type="submit" value="Odjavi se">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>