package avenue814.controller.GestioneProdotti;

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

import avenue814.model.ProductBean;
import avenue814.model.ProductModelDS;
import avenue814.model.UserBean;

@WebServlet("/removeProduct")
public class RimuoviProdottoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger("global");
	
	public RimuoviProdottoServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession userSession = request.getSession();
		UserBean user = (UserBean) userSession.getAttribute("profilo");
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		
		
		if((user.getRuolo().equals("Admin"))) {/*Eccezione*/
			request.setAttribute("errore", "Non hai accesso a questa pagina");
			response.sendRedirect("/Avenue814/PaginaAddon/errorepage.jsp");
		}
		
		String query = request.getQueryString();
		query = query.replaceAll("\\D+", "");
		
		ProductBean product = null;
		ProductModelDS productModel = new ProductModelDS(ds);
		try {
			product = productModel.retrieveProductById(Integer.parseInt(query));
			productModel.toUpdateDisp(product, false);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/Avenue814/PaginaShop/shop.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
}
