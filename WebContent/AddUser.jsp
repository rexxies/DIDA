<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="addUser">
<form method="post" action="/Project_RemoteKey/AddUserServlet">
	<table>
	<thead>
		<tr>
			<th colspan="2">Add User</th>
		</tr>
	</thead>
	
	<tbody>
		<tr>
        	<th>Name</th>
        	<th>ID</th>
        	<th>Rights</th>
	    </tr>
	    <tr>
	    	<td><input type="text" name="userName"/></td>
        	<td><input type="text" name="userID"/></td>
        	<td><input type="text" name="userRights"/></td>
		</tr>
	    <tr>
			<td><input type="submit" value="Add User" />
        		&nbsp;
            </td>                        
        </tr>
	</tbody>
	</table>
</form>
</div>
</body>
</html>