<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% HttpSession sessionUser = request.getSession();
    	if(sessionUser.getAttribute("profilo") != null){
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Aggiungi un Prodotto</title>
		<style><%@include file="../CSS/aggiungi_prodotti.css"%></style>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<script><%@include file="../JS/validAddProduct.js"%></script>
	</head>
	<body>
		<div class="main">
			<div class="head">
				<%@include file="../PaginaAddon/header.jsp" %>
			</div>
			<div class="box">
				<div class="title">
					<h2>Aggiungi un prodotto</h2>
				</div>
				<div class="box_add">
					<form name="add" action="/Avenue814/addProduct" method="POST" enctype="multipart/form-data" onsubmit="return isValidForm()">
						<div class="information">
							<input type="text" id="nome_prodotto" name="nome_prodotto" placeholder="Nome" onblur="return isValidName()">
							<input type="text" id="prezzo" name="prezzo" placeholder="Prezzo" onblur="return isValidPrice()">
							<input type="text" id="quantita" name="quantita" placeholder="Quantit�" onblur="return isValidQuantita()">
							<select id="categoria" name="categoria">
								<optgroup label="Categoria">
									<option>Maglie</option>
									<option>Felpe</option>
									<option>Pantaloni</option>
									<option>Sneakers</option>
									<option>Accessori</option>
								</optgroup>
							</select>
							<select id="sesso" name="sesso">
								<optgroup label="Sesso">
									<option>Uomo</option>
									<option>Donna</option>
								</optgroup>
							</select>
							<div id="descrizione"><textarea rows="10%" cols="20%" name="descrizione"></textarea></div>
							<input type="file" name="foto">
							<p id="error"><%if(sessionUser.getAttribute("error") != null){%><%=(String) sessionUser.getAttribute("error")%> <%} %></p>
							<input type="submit" value="Aggiungi">
					
						</div>
					</form>
				</div>
			
			</div>
		
		</div>
	</body>
</html>

<% }else{
	request.setAttribute("errore", "Non puoi accedere a questa pagina");
	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaAddon/errorpage.jsp");
	dispatcher.forward(request, response);
}%>