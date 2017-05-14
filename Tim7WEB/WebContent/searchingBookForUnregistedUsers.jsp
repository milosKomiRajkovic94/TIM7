<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Pretraga knjiga (sadrzaja) sajta</title>
</head>
<body>
	<form action="/Tim7WEB/SearchForBooksServlet2" method="post">
		<br>
		<b>Pretrazite knjigu (sadrzaj) po: </b>
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
	<form action="homePage.jsp">
				<button type="submit"><- Povratak na pocetnu stranicu!</button>
	</form>
	</table>
</body>
</html>