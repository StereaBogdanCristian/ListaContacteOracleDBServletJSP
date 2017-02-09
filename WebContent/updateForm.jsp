<%@page import="model.Prieteni"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% Prieteni prieten = (Prieteni) request.getAttribute("prieten"); %>
<% session.setAttribute("id", prieten.getId()); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica prieten</title>
</head>
<body>

	<h1>Modifica prieten</h1>
	
	<form name = "FormularUpdate" action = "updateServlet" method = "get">
		
		<label> Nume: </label>
		<input type="text"  name="nume"  value="<%= prieten.getNume() %>"/>
		<br>
		<label> Prenume: </label>
		<input type="text"  name="prenume"  value="<%= prieten.getPrenume() %>"/>
		<br>
		<label> Email: </label>
		<input type="text"  name="email"  value="<%= prieten.getEmail() %>"/>
		<br>
		<label> Numar telefon: </label>
		<input type="text" name="nrTel"  value="<%= prieten.getNrTel() %>"/>
		<br>
		<label> Varsta: </label>
		<input type="text"  name="varsta"  value="<%= prieten.getVarsta() %>">
		<br>
		<input type="submit" name="submit" value="Modifica">
		
	</form>
	
</body>
</html>