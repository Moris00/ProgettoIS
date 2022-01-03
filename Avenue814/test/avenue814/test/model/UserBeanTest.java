package avenue814.test.model;

import avenue814.model.UserBean;
import avenue814.model.CarrelloBean;
import avenue814.model.ProductBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.*;
import org.mockito.Mockito;

public class UserBeanTest {

	private UserBean bean;
	
	@BeforeEach
	public void setUp() {
		bean = new UserBean(1, "Mario", "Rossi", "mario1", "mario@gmail.com", "123", "cliente");
	}
	
	@Test 
	public void testGetCarrelloWithUser() {
		bean.setCarrello(new CarrelloBean());
		
		assertNotNull(bean.getCarrello());
	}
	
	@Test
	public void testSetCarrello() {
		CarrelloBean carrello = new CarrelloBean();
		bean.setCarrello(carrello);
		
		assertEquals(carrello, bean.getCarrello());
		
	}
	
	@Test
	public void testGetId() {
		assertEquals(1, bean.getId());
	}
	
	@Test
	public void testSetId() {
		int atteso = 2;
		bean.setId(2);
		
		assertEquals(atteso, bean.getId());
	}
	
	@Test
	public void testGetNome() {
		assertEquals("Mario", bean.getNome());	
	}
	
	@Test
	public void testSetNome() {
		bean.setNome("Luigi");
		
		assertEquals("Luigi", bean.getNome());
	}
	
	@Test
	public void testGetCognome() {
		assertEquals("Rossi", bean.getCognome());	
	}
	
	@Test
	public void testSetCognome() {
		bean.setCognome("Blue");
		
		assertEquals("Blue", bean.getCognome());
	}
	
	@Test
	public void testGetUsername() {
		assertEquals("mario1", bean.getUsername());
	}
	
	@Test
	public void testSetUsername() {
		bean.setUsername("mario2");
		
		assertEquals("mario2", bean.getUsername());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("mario@gmail.com", bean.getEmail());
	}
	
	@Test
	public void testSetEmail() {

		bean.setEmail("mario2@gmail.com");
		
		assertEquals("mario2@gmail.com", bean.getEmail());
	}
	
	@Test
	public void testGetPassword() {

		assertEquals("123", bean.getPassword());
	}
	
	@Test
	public void testSetPassword() {

		bean.setPassword("1234");
		
		assertEquals("1234", bean.getPassword());
	}
	
	@Test
	public void testGetRuolo() {

		assertEquals("cliente", bean.getRuolo());
	}
	
	@Test
	public void testSetRuolo() {

		bean.setRuolo("admin");
		
		assertEquals("admin", bean.getRuolo());
	}
	
	
}
