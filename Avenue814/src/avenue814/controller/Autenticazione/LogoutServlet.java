package avenue814.controller.Autenticazione;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger("global");

	public LogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession userSession = request.getSession();
		userSession.setAttribute("profilo", null);
		logger.info("Logout in corso...");
		response.sendRedirect("/Avenue814/PaginaHome/home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

}
