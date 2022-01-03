package avenue814.test.controller.Autenticazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import avenue814.controller.Autenticazione.LoginServlet;
import avenue814.model.UserBean;
import avenue814.model.UserDAO;

public class LoginServleTest {

	@Test
	public void testDoPost() throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		UserDAO userModel = Mockito.mock(UserDAO.class);
		UserBean user = Mockito.mock(UserBean.class);
		
		Mockito.when(request.getParameter("email")).thenReturn("riv@gmail.com");
		Mockito.when(request.getParameter("password")).thenReturn("riv123");
		Mockito.when(userModel.getLogin("riv@gmail.com", "riv123")).thenReturn(user);
		
	
		
	}
}
