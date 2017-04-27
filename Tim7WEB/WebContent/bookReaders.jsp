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
<title>Razne teme</title>
</head>
<body>
	<h2> Pokrenite neku temu ili odgovorite na neku od vec pokrenutih </h2>
	
	
	<form action="/Tim7WEB/unosNovogForuma" method="post">
		<table>
			<tr>
				<td> Naziv teme: </td>
				<td> <input name="naziv" type="text"></td>
				<td> <input type="submit" value="Unesite novu temu"> </td>
			</tr>
		</table>
	</form>
	
	<br>
	<br>
	
	<form action="/Tim7WEB/PrikazPostojecihForuma" method="post">
		<input type="submit" value="Pretrazite postojece teme">
	</form>
	
	<br>
	
	<table border="1">
		<tr>
			<td> ID FORUMA </td>
			<td> NAZIV FORUMA </td>
		</tr>
		<c:forEach items="${listaForuma}" varStatus = "i">
			<c:set var="idforuma" value="${listaForuma[i.index].idforuma}" />
				<tr>
					<td> 
						<form action="/Tim7WEB/ServletZaPrelazakNaStranicu2" method="post">
							<input type="submit" value="${idforuma}" name="id">
						</form>
					</td>
					<td> ${listaForuma[i.index].naziv} </td>
				</tr>
		</c:forEach>
	</table>
	
	
	${message}
</body>
</html>