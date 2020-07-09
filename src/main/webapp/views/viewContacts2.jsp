<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all contacts</title>
<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<script>
	function deleteRecord()
	{
		return confirm("Are you sure you want to delete this item")
		}
</script>
</head>
<h2><u>All Contacts</u></h2>
<br/>
${msg}
<br>
<a href="/">+Add new contact</a>
<br/>
<br>
<body>
<table border="1">
	<thead>
		<tr>
			<th>S.No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phno</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${contacts}" var="p" varStatus="cnt">
			<tr>
			<td>${cnt.count}</td>
			<td>${p.contactName}</td>
			<td>${p.contactEmail}</td>
			<td>${p.contactNumber}</td>
			<td><a href="/edit/${p.contactId}">Edit</a>&nbsp;&nbsp;&nbsp;<a href="/delete/${p.contactId}" onclick="deleteRecord()" >Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>