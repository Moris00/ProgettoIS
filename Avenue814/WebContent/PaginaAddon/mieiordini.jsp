<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* , avenue814.model.*"%>
    
    <% HttpSession sessionUser = request.getSession();
    	if(sessionUser.getAttribute("profilo") == null){
    		response.sendRedirect("/Avenue814/PaginaAddon/errorpage.jsp");
    		return;
    	}

    	ArrayList<?> ordini = (ArrayList<?>) sessionUser.getAttribute("ordini");
    	
    	
    	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ordini di <%=((UserBean) sessionUser.getAttribute("profilo")).getUsername() %></title>
		<style><%@include file="../CSS/mieiordini.css"%></style>
		<%@page import="avenue814.model.*"%>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	</head>
	<body>
		<div class="main">
			<div class="head">
				<%@include file="../PaginaAddon/header.jsp"%>
			</div>
			<%  if(ordini == null){
    			response.sendRedirect(response.encodeRedirectURL("../viewOrdini"));
    		}%>
			<div class="content">
				<div class="titolo"><h1 align="center">I tuoi ordini</h1></div>
				<%if (ordini.size() == 0 || ordini == null){ %>
					<div class="vuoto"><h2 align="center"><a href="/Avenue814/PaginaShop/shop.jsp?Sesso=uomo">Non hai effettuato ordini, vai allo shop</a></h2></div>
				<%}else { 
					ProductDAO modelProduct = new ProductDAO();
					 %>
				<fieldset class="fields"> 
					<legend>ID ORDER:</legend>
					<%for(int i = 0; i < ordini.size(); i++){
						OrderBean e = (OrderBean) ordini.get(i);
						ProductBean bean = modelProduct.retrieveProductById(e.getId_prodotto()); %>
					<div class="item">
						<div class="image_item">
							<img src="<%=bean.getPath_image() %>">
						</div>
						<div class="desc_item">
							<h3><%=bean.getNome()%></h3>
							<h3><%=bean.getPrezzo()%> &euro;</h3>
						</div>
						
					</div>

					<div class="tot">
							<h3>Indirizzo: <%=e.getIndirizzo() %></h3><h3>Data: <%=e.getData() %></h3><h3>Metodo Pagamento: <%=e.getMetodo_di_pagamento() %></h3>
							
							<h3>Prezzo:<%=bean.getPrezzo()%></h3>
							
							
							<%
								
							}
							}%>
					</div>
				</fieldset>
			</div>
			<div class="foot">
				<%@include file="../PaginaAddon/footer.jsp"%>
			</div>
		</div>
	</body>
</html>