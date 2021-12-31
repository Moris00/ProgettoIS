package avenue814.test.model;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.*;

import avenue814.model.OrderBean;

public class OrderBeanTest {

	private OrderBean order;
	
	@BeforeEach
	public void setUp() {
		order = new OrderBean(1, 2, "25/12/2021", "Mario", "Rossi", "Via indirizzo 123", "1234567890", "Contrassegno");
	}
	
	@Test
	public void testGetIdOrdine() {
		assertEquals(2, order.getId_order());
	}
	
	@Test
	public void testSetIdOrdine() {

		order.setId_order(1);
		
		assertEquals(1, order.getId_order());
	}
	
	@Test 
	public void testGetIdProdotto() {

		
		assertEquals(1, order.getId_prodotto());
	}
	
	@Test 
	public void testSetIdProdotto() {

		order.setId_prodotto(2);
		assertEquals(2, order.getId_prodotto());
	}
	
	@Test
	public void testGetData() {

		assertEquals("25/12/2021", order.getData());
	}
	
	@Test
	public void testSetData() {

		order.setData("22/11/2000");
		
		assertEquals("22/11/2000", order.getData());
	}
	
	@Test
	public void testGetNome() {
		
		assertEquals("Mario", order.getNome());
	}
	
	@Test
	public void testSetNome() {

		order.setNome("Luigi");
		
		assertEquals("Luigi", order.getNome());
	}
	
	@Test
	public void testGetCognome() {

		assertEquals("Rossi", order.getCognome());
	}
	
	@Test
	public void testSetCognome() {
	
		order.setCognome("Blue");
		
		assertEquals("Blue", order.getCognome());
	}
	
	@Test
	public void testGetIndirizzo() {

		assertEquals("Via indirizzo 123", order.getIndirizzo());
	}
	
	@Test
	public void testSetIndirizzo() {
	
		order.setIndirizzo("Via indirizzo 132");
		
		assertEquals("Via indirizzo 132", order.getIndirizzo());
	}
	
	@Test
	public void testGetTelefono() {
		
		assertEquals("1234567890", order.getTelefono());
	}
	
	@Test
	public void testSetTelefono() {
		
		order.setTelefono("0987654321");
		
		assertEquals("0987654321", order.getTelefono());
	}
	
	@Test
	public void testGetMetodoPagamento() {
		
		assertEquals("Contrassegno", order.getMetodo_di_pagamento());
	}
	
	@Test
	public void testSetMetodoPagamento() {
	
		order.setMetodo_di_pagamento("Visa");
		
		assertEquals("Visa", order.getMetodo_di_pagamento());
	}
	
}
