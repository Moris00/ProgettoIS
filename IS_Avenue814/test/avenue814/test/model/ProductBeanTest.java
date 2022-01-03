package avenue814.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import avenue814.model.ProductBean;

public class ProductBeanTest {
	private ProductBean prodotto;
	
	@BeforeEach
	public void setUp() {
		prodotto = new ProductBean(1, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
	}
	
	@Test
	public void testGetId(){
		assertEquals(1, prodotto.getId());
	}
	
	@Test
	public void testSetId() {
	
		prodotto.setId(2);
		
		assertEquals(2, prodotto.getId());
	}
	
	@Test
	public void testGetNome() {
	
		assertEquals("Nike Shoes", prodotto.getNome());
	}
	
	@Test
	public void testSetNome() {
		
		prodotto.setNome("Nike");
		
		assertEquals("Nike", prodotto.getNome());
	}
	
	@Test
	public void testGetPrezzo() {
		
		assertEquals(String.valueOf("12.5"), String.valueOf(prodotto.getPrezzo()));
	}
	
	@Test
	public void testSetPrezzo() {
		
		prodotto.setPrezzo(10.0);
		
		assertEquals(String.valueOf("10.0"), String.valueOf(prodotto.getPrezzo()));
	}
	
	@Test
	public void testGetDescrizione() {
		
		assertEquals("Ciaone a tutti", prodotto.getDescrizione());
	}
	
	@Test
	public void testSetDescrizione() {
		
		prodotto.setDescrizione("Ciaone");
		assertEquals("Ciaone", prodotto.getDescrizione());
	}
	
	@Test
	public void testGetCategoria() {
		
		assertEquals("Maglie", prodotto.getCategoria());
	}
	
	@Test
	public void testSetCategoria() {
		
		prodotto.setCategoria("Pantaloni");
		assertEquals("Pantaloni", prodotto.getCategoria());
	}
	
	@Test
	public void testGetQuantita() {
		
		assertEquals(10, prodotto.getQuantita());
	}
	
	@Test
	public void testSetQuantita() {
		
		prodotto.setQuantita(11);
		assertEquals(11, prodotto.getQuantita());
	}
	
	@Test
	public void testGetPathImage() {
		
		assertEquals("/path/imag.png", prodotto.getPath_image());
	}
	
	@Test
	public void testSetPathImage() {
		
		prodotto.setPath_image("/path/123.png");
		
		assertEquals("/path/123.png", prodotto.getPath_image());
	}
	
	@Test
	public void testGetSesso() {
		
		assertEquals("Donna", prodotto.getSesso());
	}
	
	@Test
	public void testSetSesso() {
		
		prodotto.setSesso("Uomo");
		assertEquals("Uomo", prodotto.getSesso());
	}
	
	@Test
	public void testGetDisponibilita() {
		
		assertEquals(true, prodotto.isDisponabilita());
	}
	
	@Test
	public void testSetDisponibilita() {
		
		prodotto.setDisponibilita(false);
		
		assertEquals(false, prodotto.isDisponabilita());
	}
	
	@Test
	public void testGetIdProp() {
		
		assertEquals(123, prodotto.getId_prop());
	}
	
	@Test
	public void testSetIdProp() {
		
		prodotto.setId_prop(1234);
		
		assertEquals(1234, prodotto.getId_prop());
	}
	
}
