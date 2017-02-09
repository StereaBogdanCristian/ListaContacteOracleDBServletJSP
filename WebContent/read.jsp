<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prieteni</title>
</head>
	
	<% String table = (String) request.getAttribute("table"); %>

<body>
	<h1>Lista prieteni</h1>
	<%= table %>
	
	<br><br>
	
	<a href="add">Adauga prieten</a>
	
</body>
</html>