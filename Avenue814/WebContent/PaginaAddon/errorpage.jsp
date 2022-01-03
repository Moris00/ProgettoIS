<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<%String stringa = (String) request.getAttribute("errore");%>
	<head>
		<meta charset="ISO-8859-1">
		<title>Error Page</title>
		<style><%@include file="../CSS/errorpage.css"%></style>
	</head>
	<body>
		<div class="main">
			<div class="head"><%@include file="../PaginaAddon/header.jsp" %></div>
		</div>
		<div class="content">
		
			<h1 align="center"><%=stringa%></h1>
		
		</div>
		<div class="foot">
			<div class="head"><%@include file="../PaginaAddon/footer.jsp" %></div>
		</div>
	</body>
</html>