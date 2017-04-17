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

	<h2> Detalji o odabranoj knjizi su: </h2>
	<table>
		<tr>
			<td> Naslov knjige: </td>
			<td> ${knj.naslov} </td>
		</tr>
		<tr>
			<td> Autor knjige: </td>
			<td> ${knj.autor} </td>
		</tr>
		<tr>
			<td> Oblast knjige: </td>
			<td> ${knj.oblast} </td>
		</tr>
		<tr>
			<td> Opis: </td>
			<td> ${knj.opis} </td>
		</tr>
		<tr>
			<td> Bestseller: </td>
			<td> ${knj.bestseller} </td>
		</tr>
		<tr>
			<td>
            	<img src="${pageContext.servletContext.contextPath }/Tim7WEB/SearchForBooksServletPicture?id=${knj.idknjiga}"  HEIGHT="20" WIDTH="20" BORDER="0"/>
            </td> 
        </tr> 
	</table>
	
	<br>

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