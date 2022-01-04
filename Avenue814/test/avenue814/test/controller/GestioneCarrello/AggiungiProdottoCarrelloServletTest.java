package avenue814.test.controller.GestioneCarrello;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

import avenue814.controller.GestioneCarrello.AggiungiProdottoCarrelloServlet;
import avenue814.model.CarrelloBean;
import avenue814.model.ProductBean;
import avenue814.model.ProductDAO;
import avenue814.model.UserBean;

public class AggiungiProdottoCarrelloServletTest {

	@Test
	public void testdoPost() throws ClassNotFoundException, SQLException, ServletException, IOException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		HttpSession session = Mockito.mock(HttpSession.class);
		ProductDAO dao = Mockito.mock(ProductDAO.class);
		ProductBean product = Mockito.mock(ProductBean.class);
		CarrelloBean carrello = Mockito.mock(CarrelloBean.class);
		AggiungiProdottoCarrelloServlet addProd = new AggiungiProdottoCarrelloServlet();
		
		UserBean user = Mockito.mock(UserBean.class);
		
		Mockito.when(request.getSession()).thenReturn(session);
		String name = "Air Force 1 Nike Bianco";
		Mockito.when(request.getParameter("product_name")).thenReturn(name);
		Mockito.when(dao.retrieveProductByName(name)).thenReturn(product);
		Mockito.when(session.getAttribute("profilo")).thenReturn(user);
		Mockito.when(user.getCarrello()).thenReturn(carrello);
		
		addProd.doPost(request, response);
		
		Mockito.verify(carrello).addProduct(product);
		Mockito.verify(user).setCarrello(carrello);	
		Mockito.verify(session).setAttribute("profilo", user);
		
	}
}
