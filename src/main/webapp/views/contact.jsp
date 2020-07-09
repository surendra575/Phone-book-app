<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<h2><u>Contact Info</u></h2>
  
</head>
<body>
<h3 style="color:green">${smsg}</h3>
<h3 style="color:red">${emsg}</h3>
<h3 style="color:red">${er}</h3>
<form:form action="/addContact" modelAttribute="contact" method="POST">
	<table>
	<form:hidden path="contactId"/>
		<tr>
			<td>Enter Name: </td>
			<td><form:input path="contactName" /></td>
		</tr>
		<tr>
			<td>Enter Email: </td>
			<td><form:input path="contactEmail"/></td>
		</tr>
		<tr>
			<td>Enter ph no: </td>
			<td><form:input path="contactNumber"/></td>
	
		</tr>
		
		<tr>
		<td><input type="reset" value="Reset"></td>
		<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form:form>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/viewAllContacts">View all contacts</a>
</body>
</html>