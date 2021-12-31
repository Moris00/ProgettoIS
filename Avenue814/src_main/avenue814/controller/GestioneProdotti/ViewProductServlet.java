package avenue814.controller.GestioneProdotti;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.sql.DataSource;

import avenue814.model.ProductDAO;

public class ViewProductServlet extends HttpServlet {

private Logger logger = Logger.getLogger("global");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ViewProductServlet(){
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String categoria = request.getParameter("Categoria");
		String sesso = request.getParameter("Sesso");

		ProductDAO productModel = new ProductDAO();
		
		if(categoria == null || categoria.equals("")) {
			try {
				
				request.setAttribute("prodotti", productModel.retrieveAllProductBySesso(sesso));
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if(categoria != null && !(categoria.equals(""))){
			
			try {
				request.setAttribute("prodotti", productModel.retrieveAllProductBySessoAndCategoria(sesso, categoria));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaShop/shop.jsp");
		dispatcher.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
}
