<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registracija</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
<style>
body {font-family: "Raleway", Arial, sans-serif}
.w3-row img {margin-bottom: -8px}
</style>
</head>
<body>
	<h3> Unesite podatke za registraciju. </h3>
	<form action="/Tim7WEB/RegistracioniServlet" method="post"> 
		<table>
			<tr>
				<td>Ime: </td>
				<td><input name="ime" type="text"></input></td>
			</tr>
			<tr>
				<td>Prezime: </td>
				<td><input name="prezime" type="text"></input></td>
			</tr>
			<tr>
				<td>Mesto: </td>
				<td><input name="mesto" type="text"></input></td>
			</tr>
			<tr>
				<td>Datum rodjenja (yyyy-mm-dd): </td>
				<td><input name="datumRodjenja" type="text"></input></td>
			</tr>
			<tr>
				<td>E-mail: </td>
				<td><input name="email" type="text"></input></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input name="password" type="password"></input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" name="button" /></td>
			</tr>
		</table>
	</form>
	<c:if test="${message == 'Uspesno!'}">
		<p>${message}</p>
		<a href="homePage.jsp"><b> Probajte se ulogovati! </b></a>
	</c:if>
	<c:if test="${message != 'Uspesno!' }">
		<a href="homePage.jsp"> <b> Povratak na pocetnu stranicu. </b></a>
	</c:if>
</body>
</html>