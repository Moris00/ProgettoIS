package avenue814.test.controller.Autenticazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

import avenue814.controller.Autenticazione.RegistrazioneServlet;
import avenue814.model.UserBean;
import avenue814.model.UserDAO;

public class RegistrazioneServletTest {

	@Test
	public void testDoPost() throws IOException, ServletException, SQLException {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		final ServletContext context = Mockito.mock(ServletContext.class);
		UserDAO dao = Mockito.mock(UserDAO.class);
		RegistrazioneServlet registrazione = new RegistrazioneServlet();
		
		String nome = "Maurizio";
		String cognome = "Ricco";
		String username = "moris123";
		String email = "moris@gmail.com";
		String password = "12345678";
		
		Mockito.when(request.getParameter("name")).thenReturn(nome);
		Mockito.when(request.getParameter("secondname")).thenReturn(cognome);
		Mockito.when(request.getParameter("password")).thenReturn(password);
		Mockito.when(request.getParameter("email")).thenReturn(email);
		Mockito.when(request.getParameter("username")).thenReturn(username);
		UserBean user = new UserBean(nome, cognome, password, email, username, "cliente");
		Mockito.when(dao.isNewUser(user)).thenReturn(true);
		Mockito.when(dao.addNewUser(user)).thenReturn(true);
		registrazione.doPost(request, response);
		
		Mockito.verify(response).sendRedirect("/Avenue814/PaginaHome/home.jsp");
		Mockito.verify(dao).isNewUser(user);
		Mockito.verify(dao).addNewUser(user);
		
		
	}
}
