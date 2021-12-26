<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="avenue814.model.* , javax.sql.DataSource"%>
<!DOCTYPE html>
<html>
	<%
	if(request.getSession() == null){
		response.sendRedirect("/Avenue813/PaginaUtili/errorpage.jsp");
		return;
	}
		
		int id = Integer.parseInt(request.getParameter("id"));
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProductBean bean = new ProductModelDS(ds).retrieveProductById(id);
		
	%>

	<head>
		<meta charset="ISO-8859-1">
		<title><%= bean.getNome()%></title>
		<style><%@include file="../CSS/product.css"%></style>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	</head>
	<body>
		<div class="main">
			<div class="head">
				<%@include file="../PaginaAddon/header.jsp"%>
			</div>
			<form action="../addProductCart" method="POST">
				<div class="product_div">
				
					<div class="product_image">
						<img src="<%= bean.getPath_image() %>" onerror="this.src='/Avenue813/immagini_prodotti/miss.png'">
				
					</div>
					<div class="product_description">
						<div class="title">
							<input type="text" value="<%=bean.getNome()%>" name="product_name" readonly>
					
						</div>
						<div class="description">
							<p><%=bean.getDescrizione()%></p>
						</div>
						<div class="prezzo">
							<p><%=bean.getPrezzo()%> &euro;</p>
						
						</div>
						<div class="taglie_acquisto">
				
							<input type="submit" value="Aggiungi al carrello">
					
						</div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>