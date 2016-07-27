<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hangman</title>
</head>

<body>
	<h1>Hangman</h1>
	<!-- TR = table row, TD is tabel colum -->
	
<FORM action="/HangmanWeb/HangmanServlet" method="post">
	<TABLE width="50%" border="0" cellpadding="0" cellspacing="1">
	<TBODY>
<!-- New row -->	
		<TR>
			<TD>
				Enter a letter
			</TD>
		
			<TD>
				Solution
			</TD>
			
			<TD>
				Chosen Letters
			</TD>
		</TR>
<!-- New row -->		
		<TR>
			<TD><!-- textfield for user input -->
				<INPUT type="text" name="userGuess"> <!-- Input field for the user's guess, name moet zelfde zijn als String bij doPost() -->
			</TD>
			
			<!-- the word with the dots-->	
			<TD>
			<c:forEach var="wordToGuess" items="${wordToGuess}">
			
  	  			<c:out value="${wordToGuess}"/>
		
			</c:forEach>
			</TD>
				
			<TD>
				<c:forEach var= "key" items="${alreadyChosenLetters}">
					<c:out value="${key.key}"/>
				</c:forEach>
			</TD>
		</TR>
<!-- New row -->		
		<TR>
			<TD><!-- submit button -->
				<INPUT type="submit" value="Guess">
			</TD> 
		</TR>
<!-- New row -->		
		<TR>
			<TD>
			<P> Je mag nog 
				<c:out value="${10 - timesGuessedWrong }"/>
				 keer raden
			</P>
			</TD>
		</TR>
<!-- New row -->		
		<TR>
			<TD>
			<c:choose>
				<c:when test="${timesGuessedWrong == 10 }">
					<h2> You Lose!!!!</h2>
				</c:when>
	
				<c:when test="${win==true}">
					<h2> You Win!!!!</h2>
				</c:when>
			</c:choose>
			</TD>
		</TR>
		
	</TBODY>
	</TABLE>
</FORM>
</body>
</html>
