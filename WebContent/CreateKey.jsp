<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="createKeyDiv">
<form method="post" action="/Project_RemoteKey/CreateKeyServlet">
	<table>
	<thead>
		<tr>
			<th colspan="4">Create Key's</th>
		</tr>
	</thead>
	
	<tbody>
		<tr>
        	<th >Enter Key</th>
			<th>Duration in minutes</th>
			<th>Number Of Times Key Is Usable</th>
	    </tr>
	    <tr>
	    	<td><input type="text" name="key"/></td>
			<td><input type="text" name="duration"/></td>
			<td><input type="text" name="timesUsable"/></td>
	    </tr>
	    <tr>
			<td><input type="submit" value="Create Key" />
        		&nbsp;
            </td>                        
        </tr>
	</tbody>
	</table>
</form>
</div>
</body>
</html>