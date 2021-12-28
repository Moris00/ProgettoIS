package avenue814.controller.Autenticazione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

import avenue814.control.database.DBConnection;
import avenue814.model.*;


public class LoginServlet extends HttpServlet {

	private Logger logger = Logger.getLogger("global");
	
	/**
	 * definisce la servlet per il login
	 * */
	private static final long serialVersionUID = 1L;
	
	public LoginServlet(){
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
			UserModelDS userModel = new UserModelDS();
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			UserBean user = userModel.getLogin(email, password);
			
			
			
			if(user != null) {
				logger.info("Indirizzamento homepage...");
				HttpSession userSession = request.getSession();
				userSession.setAttribute("profilo", user);
				
				
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaHome/home.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
