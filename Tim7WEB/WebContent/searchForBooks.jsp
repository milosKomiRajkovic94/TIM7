<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pretraga knjiga</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
<style>
body {font-family: "Raleway", Arial, sans-serif}
.w3-row img {margin-bottom: -8px}
</style>
</head>
<body>
	<form action="/Tim7WEB/SearchForBooksServlet" method="get">
		<br>
		<b>Pretrazite knjigu po: </b>
		<select name="izbor">
    	 	<option value="0">Autor</option>
     		<option value="1">Bestseller</option>
     		<option value="2">Naslov</option>
		</select>
		
		<br>
		
		<b>Unesite vrednost izabranog kriterijuma (sem ako je bestseller, onda se automatski pretrazuje, tj. izdvajaju se samo bestseller-i): </b>
		<input type="text" name="kriterijum">
		<input type="submit" value="Pretrazite knjige" name="button">
	</form>
	
	<table border="1">
   		<tr>
        	<th> Rezultati pretrage knjiga po izabranom kriterijumu </th>
    	</tr>
    	<tr>	
			<td> ID </td>
   		 	<td> NASLOV </td>
   		 	<td> AUTOR </td>
   		 	<td> OBLAST </td>
   		 	<td> OPIS </td>
   		 	<td> BESTSELLER? </td>
   		 	<td> SLIKA </td>
   		 <tr>
   		 <c:forEach items="${listaKnjiga}" varStatus="i">
   		 	<c:set var="idknjiga" value="${listaKnjiga[i.index].idknjiga}"/>
        	<tr>
        		<td>
        			<form action="/Tim7WEB/ServletZaPrelazakNaStranicu" method="post">
        				<input type="submit" value="${idknjiga}" name="idknjiga">
        			</form>
        		 </td>
            	<td>${listaKnjiga[i.index].naslov}</td>
            	<td>${listaKnjiga[i.index].autor}</td>
            	<td>${listaKnjiga[i.index].oblast} </td>
            	<td>${listaKnjiga[i.index].opis} </td>
            	<td>${listaKnjiga[i.index].bestseller}</td>
            	<td>
            		<form action="/Tim7WEB/SearchForBooksServletPicture" method="get">
            			<img src="${pageContext.servletContext.contextPath }/Tim7WEB/SearchForBooksServletPicture?id=${idknjiga}"  HEIGHT="20" WIDTH="20" BORDER="0"/>
            		</form> 
            	</td>  
       		</tr>
   		 </c:forEach>
	</table>
	
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