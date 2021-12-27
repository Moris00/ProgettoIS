package avenue814.controller.Autenticazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import avenue814.model.UserBean;
import avenue814.model.UserModelDS;

@WebServlet("/registration")
public class RegistrazioneServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistrazioneServlet() {super();}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(request.getSession().getAttribute("profilo") != null) {
			request.setAttribute("errore", "Non hai accesso a questa pagina");
			response.sendRedirect("/Avenue814/PaginaAddon/errorpage.jsp");
		}
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		
		
		UserModelDS userModel = new UserModelDS(ds);
		
		UserBean user = new UserBean(request.getParameter("name"),
				request.getParameter("secondname"),
				request.getParameter("password"),
				request.getParameter("email"),
				request.getParameter("username"), "cliente");
		
		try {
			if(userModel.isNewUser(user)) {
				userModel.addNewUser(user);
				response.sendRedirect("/Avenue814/PaginaHome/home.jsp");
			}else {
				/*Gi� esistente*/
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaAutenticazione/register.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
