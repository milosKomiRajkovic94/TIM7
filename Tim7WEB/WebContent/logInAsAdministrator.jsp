<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Ulogujte se kao administrator </title>
</head>
<body>


	
 	<center>
 		<h2> Prijavite se administratore  </h2>
 		<br>
		<form action = "/Tim7WEB/LogInServlet2" method="post">
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
				</tr>
				<tr>
					<td> <img src="images/slika5.png">
				</tr>
			</table>
			<p>${message} </p>
		</form>
	</center>
	
	<br>
	
	<form action="homePage.jsp">
				<button type="submit"><- Povratak na pocetnu stranicu!</button>
	</form>
</body>
</html>