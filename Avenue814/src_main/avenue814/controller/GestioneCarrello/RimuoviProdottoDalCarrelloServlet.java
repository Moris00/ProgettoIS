package avenue814.controller.GestioneCarrello;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import avenue814.model.*;

@WebServlet("/removeProductCart")
public class RimuoviProdottoDalCarrelloServlet extends HttpServlet {
	public RimuoviProdottoDalCarrelloServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession userSession = request.getSession();
			if(userSession == null) {/*Eccezione*/
				request.setAttribute("errore", "Non hai accesso a questa pagina");
				response.sendRedirect("/Avenue814/PaginaAddon/errorepage.jsp");
			}else {
				UserBean user = (UserBean) userSession.getAttribute("profilo");
				ProductDAO productModel = new ProductDAO();
				
				
				String nome = request.getParameter("name_product");
				
				
				try {
					ProductBean item = productModel.retrieveProductByName(nome);
					user.getCarrello().removeProduct(item);
					userSession.setAttribute("profilo", user);
					
					response.sendRedirect("/Avenue814/PaginaShop/carrello.jsp");
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				
				
			}
	}
}
