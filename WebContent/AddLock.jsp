<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="addLockDiv">
<form method="post" action="/Project_RemoteKey/AddLockServlet">
	<table>
	<thead>
		<tr>
			<th colspan="2">Add Lock</th>
		</tr>
	</thead>
	
	<tbody>
		<tr>
        	<th>Name</th>
        	<th>IP</th>
        	<th>Key</th>
        	<th>Access Level</th>
        	<th>Turn on?</th>
	    </tr>
	    <tr>
	    	<td><input type="text" name="lockName"/></td>
        	<td><input type="text" name="ipAddress"/></td>
        	<td><input type="text" name="key"/></td>
        	<td><input type="text" name="accesLevel"/></td>
        	<td><input type="text" name="enabled"/></td>
		</tr>
	    <tr>
			<td><input type="submit" value="Add Lock" />
        		&nbsp;
            </td>                        
        </tr>
	</tbody>
	</table>
</form>
</div>
</body>
</html>