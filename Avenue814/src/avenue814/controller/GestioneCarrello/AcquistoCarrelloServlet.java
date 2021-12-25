package avenue814.controller.GestioneCarrello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import avenue814.model.*;

public class AcquistoCarrelloServlet extends HttpServlet {
	public AcquistoCarrelloServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession userSession = request.getSession();
		
		if(userSession == null) {/*Eccezione*/}else {
			UserBean user = (UserBean) userSession.getAttribute("profilo");
			
			CarrelloBean carrello = user.getCarrello();
			
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String città = request.getParameter("citta");
			String indirizzo = request.getParameter("indirizzo");
			String telefono = request.getParameter("indirizzo");
			
			String metodo_di_pagamento = request.getParameter("metodo");
			
			if(metodo_di_pagamento.equals("Contrassegno")) {
				
			}else{
				
			}
			
		}
	}
}
