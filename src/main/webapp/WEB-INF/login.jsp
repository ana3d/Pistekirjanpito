<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="main.css">
<title>Please login</title>
</head>
<body>
<h1><font color="red"><c:out value="${error_message}"/></font></h1>
<div class="tableDiv">
<form method=post action="Login">
<table>
<tr>
<th>Kirjaudu sisään</th>
</tr>

<tr>
<td>Username: <input type="text" name="username" size="30" class="inputfields"></td></tr>
<tr><td>Password: <input type="password" name="password" size="30" class="inputfields"></td></tr>
<tr>
<td> <button class="button">Kirjaudu sisään</button></td>
</tr>


</table>
</form>
</div>


<div class="tableDiv">
<pre>
 Käytettävissä olevat tunnukset:
 opettaja
 oppilas
 oppilas1
 oppilas2

 Kaikkiin on sama salasana: 1234qwerty  
</pre>
</div>


</body>
</html>