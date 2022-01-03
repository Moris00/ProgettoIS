<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="avenue814.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style><%@include file="../CSS/header.css" %></style>
<style><%@include file="../CSS/mobile.css"%></style>
<style>
.selected{
 color: white;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
  $(document).ready(function(){
    $("#menuButton").click(function(){
      $("#menu").slideToggle();
    }); 
  });

</script>
</head>
<body>
	<%
		HttpSession userSession = request.getSession();
	%>

<div class="header">
				<div class="content">
							<div class="colonna1">
								<div class="logoimg">

									<a href="/Avenue814/PaginaHome/home.jsp"><img  class="logo" src="/Avenue814/IMAGES/logo_bello.png" width=135px; height=95px;></a>

								</div>
							</div>
							<div class="colonna2">
								<div class="menu">
								
									<div class="content-menu">
									
									    <ul id="lista"> 
									    
										<li><a href="/Avenue814/PaginaHome/home.jsp" class="cool-link">Home</a></li>
											<li><a href="/Avenue814/PaginaShop/shop.jsp?Sesso=uomo&Category=" class="cool-link">Uomo</a></li>
											<li><a href="/Avenue814/PaginaShop/shop.jsp?Sesso=donna&Category=" class="cool-link">Donna</a></li>
											<%if(userSession.getAttribute("profilo") == null){ %>
											<li><a href="/Avenue814/PaginaAutenticazione/login.jsp" class="cool-link">Login</a></li>
											<%}else
												
											{
												UserBean user = (UserBean) userSession.getAttribute("profilo");%>
												
												
                                              <li><a id="menuButton"><%=user.getUsername()%></a></li>
                                              
                                              <div id="menu" style="display:none;">
                                                 <p><a href="/Avenue813/PaginaAutenticazione/datipersonali.jsp">Dati Personali</a></p>
                                                 <p><a href="/Avenue814/viewOrdini">I miei ordini</a></p>
                                                 <p><a href="/Avenue813/PaginaContatti/supportoemail.jsp">Contatti</a></p>
                                                 <p><a href="https://www.instagram.com/the_avenue813/?hl=it">Social</a></p>
                                              </div>
				
  								
												
											
											
											<%} %> 
											</ul>
											</div>
											
											
										
										
									</div>
									
								</div>
								
															<div class="colonna3">
							

							
							<!--AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA-->
							
		
    
<input type="checkbox" id="hamburger"/>
<label class="menuicon" for="hamburger"><img src="/Avenue813/immagini/menu.png" id="imgmenu" alt="menu" width=50px height=50px></label>


<div id="bar"> 

</div>

    <nav class="menu-visibility">

         <ul>
            <li><a href="/Avenue813/PaginaHome/home.jsp">HOME</a></li>
            <li><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=uomo">UOMO</a></li>       
            <li><a href="/Avenue813/PaginaShop/shop.jsp?Sesso=donna">DONNA</a></li>
            <% if(userSession.getAttribute("profilo") == null){ %>
            <li><a href="/Avenue813/PaginaAutenticazione/login.jsp">LOGIN</a></li>
            <%}else{ %>
            <li><a href="/Avenue813/PaginaAutenticazione/datipersonali.jsp"><%=((UserBean) userSession.getAttribute("profilo")).getUsername() %></a></li>
            <li><a href="/Avenue814/PaginaAutenticazione/mieiordini.jsp">I MIEI ORDINI</a></li>
            <li><a href="/Avenue813/PaginaContatti/supportoemail.jsp">CONTATTI</a></li>
            <li><a href="/Avenue814/PaginaShop/carrello.jsp">CARRELLO</a></li>
            <li><a href="/Avenue814/logout">LOGOUT</a></li>
            
            <% } %>
           </ul>
  
</nav>
							
						
		
							
							<!--AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA-->
							
							
							
							
							
						
								<div class="logindiv">
								<%   if(userSession.getAttribute("profilo") == null){ %>
							
								<% } else{
										%>
										
									
										<a id="login" href="/Avenue814/PaginaShop/carrello.jsp"><img src="/Avenue814/IMAGES/carrello-png-2.png" id="imgcar" width= 50px; height=50px;></a>
									<div class="info"><a href="/Avenue814/logout">Logout</a></div>
									
									<div class="numerino">
			                           <%CarrelloBean numerino = (CarrelloBean) ((UserBean) userSession.getAttribute("profilo")).getCarrello();
			                           		if(numerino != null){%>
		                               <h3><%= numerino.getListaProdotti().size()%></h3>
		                                 </div>
									
										<% }} %>
										
								</div>
								     
							   </div>
							</div>

					
				</div>
		
		
</body>
</html>