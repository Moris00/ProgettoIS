package avenue814.controller.GestioneProdotti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import avenue814.model.ProductModelDS;
import avenue814.model.ProductBean;

@WebServlet("/viewAProduct")
public class ViewAProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewAProductServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(session.getAttribute("profilo") == null) {
			request.setAttribute("errore", "Devi effettuar il login");
			response.sendRedirect("/Avenue814/PaginaAddon/errorepage.jsp");
		}else {
		
		ProductModelDS productModel = new ProductModelDS();
		String query = request.getQueryString();
		query = query.replaceAll("\\D+", "");
		
		try{
			ProductBean product = productModel.retrieveProductById(Integer.parseInt(query));
			response.sendRedirect("/Avenue814/PaginaShop/product.jsp?id="+query+"&Sesso="+product.getSesso());
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
			
		
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
}
