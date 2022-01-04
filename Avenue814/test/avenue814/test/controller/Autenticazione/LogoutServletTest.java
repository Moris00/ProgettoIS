package avenue814.test.controller.Autenticazione;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

import avenue814.controller.Autenticazione.LogoutServlet;
import avenue814.model.UserBean;

public class LogoutServletTest {

	@Test
	public void testdoGet() throws IOException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		HttpSession session = Mockito.mock(HttpSession.class);
		UserBean user = Mockito.mock(UserBean.class);
		LogoutServlet logout = new LogoutServlet();
		
		Mockito.when(request.getSession()).thenReturn(session);
		logout.doGet(request, response);
		
		Mockito.verify(session).setAttribute("profilo", null);
		
		
		
	}
}
