package avenue814.controller.GestioneCarrello;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import avenue814.model.*;

@WebServlet("/buyCart")
public class AcquistoCarrelloServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger("global");
	
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
			DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
			CarrelloBean carrello = user.getCarrello();
			
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String città = request.getParameter("citta");
			String indirizzo = request.getParameter("indirizzo");
			String telefono = request.getParameter("indirizzo");
			
			String metodo_di_pagamento = request.getParameter("metodo");
			
			if(metodo_di_pagamento.equals("Contrassegno")) {
				String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
				for(ProductBean e: carrello.getListaProdotti()) {
					
					
					OrderBean item = new OrderBean(e.getId(), timeStamp, user.getId(), nome, cognome, indirizzo, telefono, metodo_di_pagamento);
					logger.info("OrderBean creato: "+item.getData()+" ,"+item.getId_prodotto()+" , effettuato da: "+item.getId_user());
					
					
					OrderModelDS orderModel = new OrderModelDS(ds);
					try {
						orderModel.addOrderDS(item);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}else{
				String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
				for(ProductBean e: carrello.getListaProdotti()) {
					
					
					OrderBean item = new OrderBean(e.getId(), timeStamp, nome, cognome, indirizzo, telefono, metodo_di_pagamento);
					
					OrderModelDS orderModel = new OrderModelDS(ds);
					try {
						orderModel.addOrderDS(item);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}
			
		}
	}
}
