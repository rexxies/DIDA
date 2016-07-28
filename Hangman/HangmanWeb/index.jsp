<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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

<c:if test="${player.getName() == null}">
	<H4>Insert name</H4>
	<INPUT type="text" name="userName">
</c:if>

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
					Het antwoord was:   
					<c:forEach var="answer" items="${answer}">
  	  					<c:out value="${answer}"/>
					</c:forEach>
					<TD><!-- submit button -->
						<INPUT type="submit" value="Try Again">
					</TD>
				</c:when>
	
				<c:when test="${win==true || win ==null && player.getName() !=null}">
					<h2> You Win!!!!</h2>
					<TD><!-- submit button -->
					<H3> Fill in your name</H3>
						<INPUT type="text" name="userName">
						<INPUT type="submit"  value="try again" >
    				</TD>
				</c:when>
			</c:choose>
			</TD>
		</TR>
		
	</TBODY>
	</TABLE>
</FORM>

<canvas id="hangmanCanvas"></canvas>
<script>
var frame1 = function(){
	var canvas = document.getElementById('hangmanCanvas');
	var context = canvas.getContext('2d');
	
      context.beginPath();
      context.moveTo(0, 150);
      context.lineTo(150, 150);
      context.stroke();
}
var frame2 = function() {
	var canvas = document.getElementById('hangmanCanvas');
	var context = canvas.getContext('2d');
	
      context.beginPath();
      context.moveTo(10, 0);
      context.lineTo(10, 600);
      context.stroke();
}
var frame3 = function() {
	var canvas = document.getElementById('hangmanCanvas');
	var context = canvas.getContext('2d');
	
      context.beginPath();
      context.moveTo(0, 5);
      context.lineTo(70, 5);
      context.stroke();
}
var frame4 = function() {
	var canvas = document.getElementById('hangmanCanvas');
	var context = canvas.getContext('2d');
	
      context.beginPath();
      context.moveTo(60, 5);
      context.lineTo(60, 15);
      context.stroke();
}
var torso = function() {
	var canvas = document.getElementById('hangmanCanvas');
	var context = canvas.getContext('2d');
	
      context.beginPath();
      context.moveTo(60, 36);
      context.lineTo(60, 70);
      context.stroke();
}
var rightArm = function() {
	var canvas = document.getElementById('hangmanCanvas');
	var context = canvas.getContext('2d');
	
      context.beginPath();
      context.moveTo(60, 46);
      context.lineTo(100, 50);
      context.stroke();
}
var leftArm = function() {
	var canvas = document.getElementById('hangmanCanvas');
	var context = canvas.getContext('2d');
	
      context.beginPath();
      context.moveTo(60, 46);
      context.lineTo(20, 50);
      context.stroke();
}
var rightLeg = function() {
	var canvas = document.getElementById('hangmanCanvas');
	var context = canvas.getContext('2d');
	
      context.beginPath();
      context.moveTo(60, 70);
      context.lineTo(100, 100);
      context.stroke();
}
var leftLeg = function() {
	var canvas = document.getElementById('hangmanCanvas');
	var context = canvas.getContext('2d');
	
      context.beginPath();
      context.moveTo(60, 70);
      context.lineTo(20, 100);
      context.stroke();
}
var head = function() {
	var canvas = document.getElementById('hangmanCanvas');
	var context = canvas.getContext('2d');
    context.beginPath();
    context.arc(60, 25, 10, 0, Math.PI*2, true);
    context.stroke();
}
</script>

<c:choose>
	<c:when test="${timesGuessedWrong == 1}">
		<script>frame1();</script>
	</c:when>
	<c:when test="${timesGuessedWrong == 2}">
		<script>frame1();</script>
		<script>frame2();</script>
	</c:when>
	<c:when test="${timesGuessedWrong == 3}">
		<script>frame1();</script>
		<script>frame2();</script>
		<script>frame3();</script>
	</c:when>
	<c:when test="${timesGuessedWrong == 4}">
		<script>frame1();</script>
		<script>frame2();</script>
		<script>frame3();</script>
		<script>frame4();</script>
	</c:when>
	<c:when test="${timesGuessedWrong == 5}">
		<script>frame1();</script>
		<script>frame2();</script>
		<script>frame3();</script>
		<script>frame4();</script>
		<script>head();</script>
	</c:when>
	<c:when test="${timesGuessedWrong == 6}">
		<script>frame1();</script>
		<script>frame2();</script>
		<script>frame3();</script>
		<script>frame4();</script>
		<script>head();</script>
		<script>torso();</script>
	</c:when>
	<c:when test="${timesGuessedWrong == 7}">
		<script>frame1();</script>
		<script>frame2();</script>
		<script>frame3();</script>
		<script>frame4();</script>
		<script>head();</script>
		<script>torso();</script>
		<script>leftArm();</script>
	</c:when>
	<c:when test="${timesGuessedWrong == 8}">
		<script>frame1();</script>
		<script>frame2();</script>
		<script>frame3();</script>
		<script>frame4();</script>
		<script>head();</script>
		<script>torso();</script>
		<script>leftArm();</script>
		<script>rightArm();</script>
	</c:when>
	<c:when test="${timesGuessedWrong == 9}">
		<script>frame1();</script>
		<script>frame2();</script>
		<script>frame3();</script>
		<script>frame4();</script>
		<script>head();</script>
		<script>torso();</script>
		<script>leftArm();</script>
		<script>rightArm();</script>
		<script>leftLeg();</script>
	</c:when>
	<c:when test="${timesGuessedWrong == 10}">
		<script>frame1();</script>
		<script>frame2();</script>
		<script>frame3();</script>
		<script>frame4();</script>
		<script>head();</script>
		<script>torso();</script>
		<script>leftArm();</script>
		<script>rightArm();</script>
		<script>leftLeg();</script>
		<script>rightLeg();</script>
	</c:when>
</c:choose>

</body>
</html>
