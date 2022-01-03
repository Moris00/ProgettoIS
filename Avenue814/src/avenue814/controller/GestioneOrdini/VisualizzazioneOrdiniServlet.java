package avenue814.controller.GestioneOrdini;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import avenue814.model.OrderBean;
import avenue814.model.OrderDAO;
import avenue814.model.UserBean;

@WebServlet("/viewOrdini")
public class VisualizzazioneOrdiniServlet extends HttpServlet{

	private static Logger logger = Logger.getLogger("global");
	
	public VisualizzazioneOrdiniServlet() {super();}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession userSession = request.getSession();
		logger.info("Ricerca ordini...");
		
		if(userSession == null) {
			request.setAttribute("errore", "Non hai accesso a questa pagina");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaAddon/errorpage.jsp");
			dispatcher.forward(request, response);
		}else {
			OrderDAO modelOrder = new OrderDAO();
			UserBean user = (UserBean) userSession.getAttribute("profilo");
			try {
				ArrayList<OrderBean> ordini = modelOrder.searchOrderById(user.getId());
				userSession.setAttribute("ordini", ordini);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaAddon/mieiordini.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
