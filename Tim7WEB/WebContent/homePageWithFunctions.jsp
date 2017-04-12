<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pocetna stranica</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
<style>
body {font-family: "Raleway", Arial, sans-serif}
.w3-row img {margin-bottom: -8px}
</style>
</head>
<body>
	<h2> Dobrodosli na nasu pocetnu stranicu korisnice ${k.ime} ${k.prezime} !</h2>
	
	<b>Postovani korisnice, ispod su vam dostupne funkcije: </b>
	
	<center>
			<form action="insertionOfBook.jsp">
				<button type="submit">Unos knjige</button>
			</form>
			
			<br>
			
			<form action="searchForBooks.jsp">
				<button type="submit">Pretraga knjiga</button>
			</form>
	</center>
	
	<form action="LogOutServlet" method="post">
		<input type="submit" value="Odjavi se"> 
</form>
</body>
</html>