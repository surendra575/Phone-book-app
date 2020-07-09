<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all contacts</title>
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script>
	function deleteRecord()
	{
		return confirm("Are you sure you want to delete this item");
		}

	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
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
<table border="1" id="contactTbl">
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
			<td><a href="/edit/${p.contactId}">Edit</a>&nbsp;&nbsp;&nbsp;<a href="/delete/${p.contactId}" onclick="return deleteRecord()" >Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>