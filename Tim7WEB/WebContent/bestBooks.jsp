<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Najbolje ocenjene knjige u poslednjih mesec dana </title>
</head>
<body>

	<h2> Pretrazite najbolje ocenjene knjige u poslednjih mesec dana </h2>
	
	<form action="/Tim7WEB/SearchForBooksServlet3" method="post">
		<input type="submit" value="Pretraga najboljih ocenjenih knjiga: ">
	</form>
	
	<table border="1">
   		<tr>
        	<th> Rezultati pretrage knjiga po izabranom kriterijumu </th>
    	</tr>
    	<tr>	
   		 	<td> NASLOV </td>
   		 	<td> AUTOR </td>
   		 	<td> OBLAST </td>
   		 	<td> OPIS </td>
   		 	<td> BESTSELLER? </td>
   		 	<td> OCENA </td>
   		 <tr>
   		 <c:forEach items="${listaKnjiga}" varStatus="i">
   		 	<c:set var="idknjiga" value="${listaKnjiga[i.index].idknjiga}"/>
        	<tr>
            	<td>${listaKnjiga[i.index].naslov}</td>
            	<td>${listaKnjiga[i.index].autor}</td>
            	<td>${listaKnjiga[i.index].oblast} </td>
            	<td>${listaKnjiga[i.index].opis} </td>
            	<td>${listaKnjiga[i.index].bestseller}</td>
            	<td>${listaKnjiga[i.index].ocena} </td>  
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