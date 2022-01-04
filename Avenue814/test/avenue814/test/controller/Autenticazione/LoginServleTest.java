package avenue814.test.controller.Autenticazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;


import avenue814.controller.Autenticazione.LoginServlet;
import avenue814.model.UserBean;
import avenue814.model.UserDAO;

public class LoginServleTest {

	@Test
	public void testDoPost() throws ServletException, IOException, ClassNotFoundException, SQLException {
		LoginServlet login = new LoginServlet();
		
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		UserDAO userModel = Mockito.mock(UserDAO.class);
		UserBean user = Mockito.mock(UserBean.class);
		RequestDispatcher dispatcher = Mockito.mock(RequestDispatcher.class);
		ServletContext context = Mockito.mock(ServletContext.class);
		
		
		
		Mockito.when(request.getParameter("email")).thenReturn("riv@gmail.com");
		Mockito.when(request.getParameter("password")).thenReturn("riv123");
		Mockito.when(userModel.getLogin("riv@gmail.com", "riv123")).thenReturn(user);
		Mockito.when(login.getServletContext()).thenReturn(context);
		Mockito.when(context.getRequestDispatcher("/PaginaHome/home.jsp")).thenReturn(dispatcher);
		
		login.doPost(request, response);
		
		
		Mockito.verify(dispatcher).forward(request, response);
		
	}
}
