<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="openDoorDiv">
<form method="post" action="/Project_RemoteKey/OpenDoorServlet">
	<table>
	<thead>
		<tr>
			<th colspan="2">Open Door</th>
		</tr>
	</thead>
	
	<tbody>
	    <tr>
	    	<td>Door Name</td>
	    	<td><input type="text" name="doorName"/></td>
        </tr>
	    <tr>
			<td><input type="submit" value="Open Door" />
        		&nbsp;
            </td>                        
        </tr>
	</tbody>
	</table>
</form>
</div>
</body>
</html>