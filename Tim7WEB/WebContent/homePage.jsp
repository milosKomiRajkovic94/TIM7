<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
<style>
body {font-family: "Raleway", Arial, sans-serif}
.w3-row img {margin-bottom: -8px}
</style>
<title> Pocetna stranica </title>
</head>
<body>

	<center>
	<h3> Dobrodosli na nasu pocetnu stranicu ljubitelja knjiga!</h3>
	</center>
	
	<br>
	<br>
	
	-Molim vas ulogujte se ili se registrujte preko ponudjenog linka ispod! 
	
	<br>
	
	<form action = "/Tim7WEB/LogInServlet" method="post">
			<table>
				<tr> 
					<td> Unesite vas e-mail: </td>
					<td> <input name="email" type="text"></input> </td>
				</tr>
				<tr>
					<td> Unesite vasu lozinku: </td>
					<td> <input name="password" type="password"></input></td>
				</tr>
				<tr>
					<td><input type="submit" value="Ulogujte se!" name="button"/></td>
					<td> <a href="/Tim7WEB/RegistracioniServlet"><b> Registrujte se prvo! </b> </a>	
					<td> <a href="logInAsAdministrator.jsp"> <b> Prijavite se kao administrator! </b></a>	
				</tr>
			</table>
			<p>${message} </p>
	</form>
	
	<br>
	
	<b> Kao neregistrovani korisnik imate mogucnost samo pretrage knjiga (sadrzaja) sajta </b>
	
	<br>
	
	<a href="searchingBookForUnregistedUsers.jsp"> <b> Pretrazite knjige </b></a>
	
	<br>
	
	<form action="/Tim7WEB/PrikazZanimljivostiServlet" method="post">
		<input type="submit" value="Prikazi zanimljivosti">
	</form>
	
	<table border="1">
		<tr>
        		<th> Rezultati pretrage trenutnih zanimljivosti </th>
    	</tr>
    	<tr>	
			<td> NASLOV </td>
			<td> DATUM </td>
   		 <tr>
   		 <c:forEach items="${listaZanimljivosti}" varStatus="i">
   		    <tr>
   		    	<td> ${listaZanimljivosti[i.index].nazivSajma} </td>
   		    	<td> ${listaZanimljivosti[i.index].datumSajma} </td>
   		    </tr>
   		  </c:forEach>
	</table>
	
	<center>
		<img src="images/slika1.jpg" BORDER="1"/>
	</center>
	            	
</body>
</html>