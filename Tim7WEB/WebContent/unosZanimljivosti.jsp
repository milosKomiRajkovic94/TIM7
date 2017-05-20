<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unos zanimljivosti</title>
</head>
<body>
	<h2> Unesite zanimljivost (sajam, bestseller ili nesto sto ce biti objavljeno na pocetnoj strani): </h2>
	
	<form action="/Tim7WEB/UnosZanimljivostiServlet" method="post">
		<table>
			<tr>
				<td> Tekst zanimljivosti: </td>
				<td> <input type="text" name="tekst"> </td>
			</tr>
			<tr>
				<td> Datum (yyyy-mm-dd): </td>
				<td> <input type="text" name="datum"> </td>
			</tr>
			<tr>
				<td> <input type="submit" value = "Unesi zanimljivost"> </td>
				<td> ${message} </td>
			</tr>
		</table>
	</form>
	
	<br>
	
	<img src="images/slika6.jpg">
	
	<br>
	
	<form action="LogOutServlet2" method="post">
		<input type="submit" value="Odlogujte se administratore!"> 
	</form>
	
	
</body>
</html>