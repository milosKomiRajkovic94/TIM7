<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unos knjige </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
<style>
body {font-family: "Raleway", Arial, sans-serif}
.w3-row img {margin-bottom: -8px}
</style>
</head>
</head>
<body>
	<form action="/Tim7WEB/InsertionOfBookServlet" method="post"> 
		<h2> Unesite podatke o knjizi korsnice ${k.ime} ${k.prezime}: </h2>
		
		<table>
			<tr>
				<td>Naslov: </td>
				<td><input name="naslov" type="text"></input></td>
			</tr>
			<tr>
				<td>Autor: </td>
				<td><input name="autor" type="text"></input></td>
			</tr>
			<tr>
				<td>Oblast: </td>
				<td><input name="oblast" type="text"></input></td>
			</tr>
			<tr>
				<td>Opis: </td>
				<td><input name="opis" type="text"></input></td>
			</tr>
			<tr>
				<td>Da li je bestseller? </td>
				<td>
				<input type="radio" name="bestseller" value="true"> <b> Da </b> 
				<input type="radio" name="bestseller" value="false"checked> <b>Ne</b></td>
			</tr>
			<tr>
				<td>Izaberite sliku sa racunara ako zelite (do 1048576 bajtova)  </td>
				<td><input name="slika" type="file" accept=".jpg, .jpeg, .png" value="Odaberite sliku"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Unesite knjigu" name="button" /></td>
			</tr>
		</table>
	</form>
		
	${message}
	<table>
	<tr>
	<td>
	<form action="homePageWithFunctions.jsp">
				<button type="submit"><- Povratak na pocetnu stranicu sa funkcijama!</button>
	</form>
	<form action="LogOutServlet" method="post">
		<input type="submit" value="Odjavi se"> 
	</form>
	</td>
	</tr>
	</table>
	
</body>
</html>