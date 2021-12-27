<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* ,avenue814.model.*"%>
    
<%
	Collection<?> products = (Collection<?>) request.getAttribute("prodotti");

	String error = (String) request.getAttribute("error");
	HttpSession sessionUser = request.getSession();
		String sesso = request.getParameter("Sesso");
		String category = request.getParameter("Category");
		sessionUser.setAttribute("error", null);
			if(sesso == null){
				sesso = "uomo";
			}
		
			
			if(products == null && category == null){
				response.sendRedirect(response.encodeRedirectURL("../viewProduct?Sesso="+sesso));
			}else{
			
			if(category != null){
				response.sendRedirect(response.encodeRedirectURL("../viewProduct?Sesso="+sesso+"&Category="+category));
			}
		
		}

%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Benvenuti nello Shop Avenue813</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<style>
				<%@include file="../CSS/shopstyle.css" %>
		</style>
		
		<script><%@include file ="../JS/ricercaScript.js"%></script>
		
		<script>
			function displayResult(listXML, id){
				try{
					var obj = document.getElementById(id);
					obj.style.display = "block";
					if(obj != null && obj.style.display == "block"){
						var size = listXML.getElementsByTagName("product_name").length;
							var i = 0;
							while(i < size){
								var link = document.createElement("a");
								var id = listXML.getElementsByTagName("product_id")[i].firstChild.nodeValue;
								var sesso = listXML.getElementsByTagName("product_sesso")[i].firstChild.nodeValue;
								link.href = "/Avenue813/PaginaShop/user/product.jsp?id="+id+"&Sesso="+sesso;
								
								
								obj.appendChild(link);
								obj.appendChild(document.createElement("br"));
								
								var rd = listXML.getElementsByTagName("product_name")[i].firstChild.nodeValue;
								obj.getElementsByTagName("a")[i].innerHTML = rd;
								i++;
							}
										
					}
				}catch(e1){
					alert(e1);
				}
			}
		</script>
		
	</head>
	
	<body>
		
		<div class="main">
			<div class="head">
			
			<%@include file="../PaginaAddon/header.jsp"%>
			</div>
			
		     
			<div class="shopmain">	
					<div class="category">
					
						<div class="content_category">
							
							<input type="search" name="cerca" id="cerca" placeholder="Barra di ricerca" onblur="ricercaAJAX('content_search', '/Avenue813/SearchProductServlet', displayResult, document.getElementById('cerca').value);">
							<div id="content_search"></div>
							 <%
							 	UserBean user = (UserBean) session.getAttribute("profilo");
							 	if(user != null){
								 	if(user.getRuolo().equals("admin") || user.getRuolo().equals("rivenditore")){
							 	%>
								<button onclick="location.href='/Avenue814/PaginaShop/aggiungi_prodotti.jsp'">Aggiungi prodotto</button>
							<% }} %><br>
							<form action="/Avenue814/viewProduct?Sesso=uomo" method="GET">
								<input type="text" id="cose" name="Sesso" value="<%=sesso%>" readonly>
								<input type="submit" name="Categoria" value="Maglie"><br>
								<input type="submit" name="Categoria" value="Felpe"><br>
								<input type="submit" name="Categoria" value="Pantaloni"><br>
								<input type="submit" name="Categoria" value="Sneakers"><br>
								<input type="submit" name="Categoria" value="Accessori"><br>
							</form>
						</div>
						
					</div>
					<div class="products">
				
					<div class="products_title">
						<span></span>
					</div>
					
					<div class="products_content">
					
						<div class="list">
						<%
							if(products != null && products.size() > 0 ){
								Iterator<?> it = products.iterator();
								while(it.hasNext()){
									ProductBean bean = (ProductBean)it.next();
									if(bean.isDisponabilita()){
									
						%>
						
						
							<div class="product">
								<%
									if(user != null){
								if(user.getRuolo().equals("admin")){ %>
								<div class="remove_product">
									<form name="remove" action="/Avenue814/removeProduct" method="GET">
										<input type="submit" name=<%=bean.getId()%> value="X">
									</form>
								</div>
								<% }else if(user.getRuolo().equals("rivenditore") && bean.getId_prop() == user.getId()){
									%>
									
									<div class="remove_product">
									<form name="remove" action="/Avenue814/removeProduct" method="GET">
										<input type="submit" name=<%=bean.getId()%> value="X">
									</form>
									</div>
									
								<%}} %>
								<div class="image_product">
									<img src="<%=bean.getPath_image() %>" width=150px height="150px" onerror="this.src='/Avenue813/immagini_prodotti/error.png'">
								</div>
								<div class="buy_price">
									<div class="product_name">
										<span class="nome_prodotto"><%= bean.getNome() %></span>
									
									</div>
									<div class="buy_button">
									<form action="/Avenue814/viewAProduct" method="GET">
										<input type="submit" value="Dettagli" name=<%=bean.getId()%>>
									</form>
									</div>
									<div class="price">
										<% if(sessionUser.getAttribute("profilo") == null) { %>
											<span> <a href="/Avenue813/PaginaAutenticazione/login.jsp">Accedi!!</a></span>
										<%	}else{ %>
											<span class="prezzo_prodotto"><%= bean.getPrezzo() %> &euro;</span>
										<%} %>
									</div>
										
								</div>
							</div>
						
						<%
									}
								}
							} 
						%>
						
						</div>
					
					</div>
				</div>
				<div class="carrello">
						<div class="content_carrello">
							<div class="item">
								<img src="/Avenue813/immagini/Logo-Nike-Swoosh.png" alt="primaimmagine" width=100% height=100%>
							</div>
							<div class="item">
								<img src="/Avenue813/immagini/ADIDAS.jpeg" alt="primaimmagine" width=100% height=100%>
							</div>
							<div class="item">
								<img src="/Avenue813/immagini/PUMA.jpeg" alt="primaimmagine" width=100% height=100%>
							</div>
							<div class="item">
								<img src="/Avenue813/immagini/SUPREME.jpeg" alt="primaimmagine" width=100% height=100%>
							</div>
							<div class="item">
								<img src="/Avenue813/immagini/BULLS.jpeg" alt="primaimmagine" width=100% height=100%>
							</div>
							<div class="item">
								<img src="/Avenue813/immagini/LOGHI.jpeg" alt="primaimmagine" width=100% height=100%>
							</div>
						</div>
					
				</div>
					
				</div>
			 
				<div id="footer">
					<%@ include file="../PaginaAddon/footer.jsp"%>
				</div>
		</div>
		
		
	</body>
	<script type="text/javascript">
		function clickButton(){
			var xhr = new XMLHttpRequest();
			
			xhr.open('GET', 'ProductControl1', true);
			xhr.send(null);
			
		}
	</script>
</html>