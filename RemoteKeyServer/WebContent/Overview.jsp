<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Overview</title>
</head>

<body>

<p>Welkom ${param["username"]}</p>
<div>
	<a href="/Project_RemoteKey/AddUser.jsp">Add User</a> <br>
	<a href="/Project_RemoteKey/OpenDoor.jsp">Open Door</a> <br>
	<a href="/Project_RemoteKey/CreateKey.jsp">Create Key</a> <br>
	<a href="/Project_RemoteKey/AddLock.jsp">Add Lock</a> <br>
</div>

</body>
</html>