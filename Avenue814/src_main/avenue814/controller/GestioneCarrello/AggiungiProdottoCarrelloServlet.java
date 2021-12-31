package avenue814.controller.GestioneCarrello;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import avenue814.model.CarrelloBean;
import avenue814.model.ProductBean;
import avenue814.model.ProductDAO;
import avenue814.model.UserBean;


@WebServlet("/addProductCart")
public class AggiungiProdottoCarrelloServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger("global");
	
	public AggiungiProdottoCarrelloServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Aggiunta del prodotto al carrello in corso...");
		HttpSession userSession = request.getSession();	
		UserBean user = (UserBean) userSession.getAttribute("profilo");
		
		if(user == null) {
			/*Eccezione*/
			request.setAttribute("errore", "Non hai accesso a questa pagina");
			response.sendRedirect("/Avenue814/PaginaAddon/errorepage.jsp");
		}else {
			String name = request.getParameter("product_name");
			ProductDAO productModel = new ProductDAO();
			try {
				ProductBean product = productModel.retrieveProductByName(name);
				logger.info("Trovato il prodotto "+product.getNome());
				user.getCarrello().addProduct(product);;
				userSession.setAttribute("profilo", user);
				response.sendRedirect("/Avenue814/PaginaShop/shop.jsp?Sesso="+product.getSesso());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	}
}
