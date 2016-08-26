<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/Css.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>



<form action="/Project_RemoteKey/LoginServlet" method="post">
	<table border="1" cellpadding="5" cellspacing="2">
		<thead>
			<tr>
            	<th colspan="2">Login Here</th>
            </tr>
                </thead>
            <tbody>
            	<tr>
                	<td>username</td>
                        <td><input type="text" name="username" required/></td>
                </tr>
                <tr>
                	<td>password</td>
                        <td><input type="password" name="password" required/></td>
                </tr>
                <tr>
                	<td colspan="2" align="center"><input type="submit" value="Login" />
                            &nbsp;&nbsp;
                            <input type="reset" value="Reset" />
                    </td>                        
                </tr>                    
                </tbody>
            </table>
        </form>
</body>
</html>