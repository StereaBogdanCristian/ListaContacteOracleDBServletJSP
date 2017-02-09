<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adauga prieten</title>
</head>
<body>
	<h1>Adauga prieten</h1>
	
	<form name = "FormularAdauga" action = "Adauga" method = "get">
		
		<label> Nume: </label>
		<input type="text"  name="nume"  value="" />
		<br>
		<label> Prenume: </label>
		<input type="text"  name="prenume"  value=""/>
		<br>
		<label> Email: </label>
		<input type="text"  name="email"  value=""/>
		<br>
		<label> Numar telefon: </label>
		<input type="text" name="nrTel"  value=""/>
		<br>
		<label> Varsta: </label>
		<input type="text"  name="varsta"  value="">
		<br>
		<input type="submit" name="submit" value="Adauga">
		
		
		
	</form>
</body>
</html>