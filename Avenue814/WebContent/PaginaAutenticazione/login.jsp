<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String error = (String) request.getAttribute("errorLogin"); 
    	if(request.getAttribute("profilo") != null){
    		request.setAttribute("errore", "Non puoi accedere a questa pagina");
	    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaAddon/errorpage.jsp");
			dispatcher.forward(request, response);
    	}%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Login Page</title>
		<script><%@include file="../JS/correct_login.js"%></script>
		<style><%@include file="../CSS/loginstyle.css" %></style>
	</head>
	<body>
	
		<div class="login-div">
		<br>
		          <h1 align="center">LOGIN</h1>
			
			<form name="loginForm" class="form1" action="${pageContext.request.contextPath}/login" method="POST">
			<fieldset class="fields"> 
  		        <legend>Inserisci i tuoi dati</legend> 
				<div class="login-content">
					<div class="content">
						<div class="textbox"><input type="text" name="email" id="email" size=20 id="text" placeholder="Email" onblur=""></div>
						<p id="error_username"></p>
						<div class="textbox"><input type="password" name="password" id="password" size=20 id="text" placeholder="Password" onblur="return isValidPassword()"></div>
						<p id="error_password"></p>
					</div>
					<% if(error != null){ %><div class="error_div"><p id="errorLogin"><%=request.getAttribute("errorLogin") %></div><%} %>
					<div class="login">
						<input type="submit" value="Login" class="button" >
						<input type="button" onclick="location.href='/Avenue814/PaginaAutenticazione/register.jsp'" value="Register Page" class="button" >
					</div>
				</div>
				</fieldset>
			</form>
			
		</div>
		
	</body>
</html>