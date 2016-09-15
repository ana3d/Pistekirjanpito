<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Tervetuloa <c:out value="${user.name}" />!</title>
</head>
<body>
<div class="div">
Käyttäjätunnus: <c:out value="${user.login}" /><br>
Nimi: <c:out value="${user.name}" /><br>
Oikeudet: <c:if test="${accessLevel == 0 }"> Oppilas </c:if><c:if test="${accessLevel == 1 }"> Opettaja </c:if> <c:if test="${accessLevel > 1 }"> Ylläpitäjä </c:if>
<c:if test="${accessLevel == 2}">
<div><font size=1>
<br>Legend: <br>
AccessLevel<br>
0 = Oppilas<br>
1 = Opettaja<br>
2 = Admin
</font>
</div>
</c:if>
<br><form method=post action="Logout"><button class="button">Logout</button></form>
</div>
<%-- Teacher view --%>
<c:if test="${accessLevel == 1}">


<div class="tableDiv">
   
<table>
<thead>
<tr>
<td>Oppilas</td>
<td>Harjoitus 1</td>
<td>Harjoitus 2</td>
<td>Harjoitus 3</td>
<td>Harjoitus 4</td>
<td>Harjoitus 5</td>
<td>Harjoitus 6</td>
<td>Harjoitus 7</td>
<td>Edit</td>
</tr>

<c:forEach var="data" items="${students}" varStatus="status">

      
<tr>
<form method="post" action="Edit"> 
<td><c:out value="${data.name}" />
<td><input type="number" step="1" min=0 max=5 name="H1_arvosana" value="<c:out value="${arvosanat[status.index].h1}" />" ></td>
<td><input type="number" step="1" min=0 max=5 name="H2_arvosana" value="<c:out value="${arvosanat[status.index].h2}" />" ></td>
<td><input type="number" step="1" min=0 max=5 name="H3_arvosana" value="<c:out value="${arvosanat[status.index].h3}" />" ></td>
<td><input type="number" step="1" min=0 max=5 name="H4_arvosana" value="<c:out value="${arvosanat[status.index].h4}" />" ></td>
<td><input type="number" step="1" min=0 max=5 name="H5_arvosana" value="<c:out value="${arvosanat[status.index].h5}" />" ></td>
<td><input type="number" step="1" min=0 max=5 name="H6_arvosana" value="<c:out value="${arvosanat[status.index].h6}" />" ></td>
<td><input type="number" step="1" min=0 max=5 name="H7_arvosana" value="<c:out value="${arvosanat[status.index].h7}" />" ></td>
<td> <input type="hidden" name="id"	value="${data.id}"> <input type="hidden" name="user" value="${user.login}" /><button class="button">Tallenna</button> </td>
</form>
</tr>
</c:forEach>


</table>

</div>
</c:if>
<%-- Student view  --%>
<c:if test="${accessLevel == 0}">
<div class="tableDiv">
<table>
<thead>
<tr>
<th colspan=7>Arvosanat</th>
</tr>
<tr>
<td>Harjoitus 1</td>
<td>Harjoitus 2</td>
<td>Harjoitus 3</td>
<td>Harjoitus 4</td>
<td>Harjoitus 5</td>
<td>Harjoitus 6</td>
<td>Harjoitus 7</td>
</tr>
<tr>
 
<td><input name="H1_arvosana" value="<c:out value="${arvosana.h1}" />" disabled></td>
<td><input name="H2_arvosana" value="<c:out value="${arvosana.h2}" />" disabled></td>
<td><input name="H3_arvosana" value="<c:out value="${arvosana.h3}" />" disabled></td>
<td><input name="H4_arvosana" value="<c:out value="${arvosana.h4}" />" disabled></td>
<td><input name="H5_arvosana" value="<c:out value="${arvosana.h5}" />" disabled></td>
<td><input name="H6_arvosana" value="<c:out value="${arvosana.h6}" />" disabled></td>
<td><input name="H7_arvosana" value="<c:out value="${arvosana.h7}" />" disabled></td>
</tr>


</table>
</div>
</c:if>
<%--  Admin view --%>
<c:if test="${accessLevel == 2}">
<div class="tableDiv">
<table>
<thead>
<tr>
<th colspan="3">Users</th>
</tr>
<tr>
<td>Name</td><td>Login</td><td>Access level</td></tr>

<c:forEach var="data" items="${students}" >

<tr>
<td><c:out value="${data.name}" /></td>
<td><c:out value="${data.login}" /></td>
<td><c:out value="${data.accessLevel}" /></td>
</tr>



</c:forEach>
</table>
 </div>
 
 <div class="tableDiv">
 <form method="post" action="NewUser">
 <table>
 <thead>
 <tr>
 <th colspan="2">Uusi käyttäjä</th>
 </thead>
 <tr><td>Nimi</td><td><input type="text" size="30" name="name" class="inputfields" required></td></tr>
 <tr><td>Käyttäjätunnus</td><td> <input type="text" size="30" name="login" class="inputfields" required></td></tr>
 <tr><td>Salasana </td><td><input type="text" size="30" name="password" class="inputfields" required></td></tr>
  <tr><td>Access Level</td><td> <select name="accessLevel">
  <option value="0">Oppilas</option>
  <option value="1">Opettaja</option>
  <option value="2">Ylläpitäjä</option>
</select></td></tr>
<input type="hidden" name="user" value="${user.login}" />
<tr><td colspan="2"><button class="button">Lisää käyttäjä</button></td></tr>
 </table>
 </form>
  </div>
</c:if>














</body>
</html>