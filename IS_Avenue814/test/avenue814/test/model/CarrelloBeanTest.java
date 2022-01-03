package avenue814.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.*;

import org.junit.jupiter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import avenue814.model.*;

public class CarrelloBeanTest {

	
	@Test
	public void TestaddProduct(){
		ProductBean prodotto = new ProductBean(1, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		CarrelloBean carrello = new CarrelloBean();
		
		carrello.addProduct(prodotto);
		
		assertEquals(carrello.getListaProdotti().get(0), prodotto);
	}
	
	@Test 
	public void TestaddProductEmpty() {
		ProductBean prodotto = null;
		CarrelloBean carrello = new CarrelloBean();
		
		assertThrows(NullPointerException.class, () -> carrello.addProduct(prodotto));
	}
	
	@Test
	public void TestRemoveProduct() {
		ProductBean prodotto = new ProductBean(1, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		CarrelloBean carrello = new CarrelloBean();
		
		carrello.addProduct(prodotto);
		carrello.removeProduct(prodotto);
		
		assertEquals(carrello.getListaProdotti().size(), 0);
	}
	
	@Test
	public void TestRemoveProductMissed() {
		ProductBean prodotto = new ProductBean(1, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		ProductBean prodotto1 = new ProductBean(2, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		CarrelloBean carrello = new CarrelloBean();
		
		carrello.addProduct(prodotto);
		carrello.removeProduct(prodotto1);
		
		assertEquals(carrello.getListaProdotti().size(), 1);
		
	}
	
	@Test
	public void TestSearchProductGetIndex() {
		ProductBean prodotto = new ProductBean(1, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		CarrelloBean carrello = new CarrelloBean();
		
		carrello.addProduct(prodotto);
		int i = carrello.searchProductGetIndex(prodotto);
		
		assertEquals(i, 0);
	}
	
	@Test
	public void TestSearchProductGetIndexMissed() {
		ProductBean prodotto = new ProductBean(1, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		ProductBean prodotto1 = new ProductBean(2, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		
		CarrelloBean carrello = new CarrelloBean();
		
		carrello.addProduct(prodotto);
		int i = carrello.searchProductGetIndex(prodotto1);
		
		assertEquals(i, -1);
	} 
	
	@ParameterizedTest
	@MethodSource("TestAddPriceNumbs")
	public void TestAddPrice(double prezzo, double atteso) {
		CarrelloBean carrello = new CarrelloBean();
		carrello.addPrice(prezzo);
		double attuale = carrello.getPrezzoTot();
		assertEquals(atteso, attuale);
	}
	
	private static Stream<Arguments> TestAddPriceNumbs(){
		return Stream.of(Arguments.of(-1, -1), Arguments.of(0, 0), Arguments.of(1,1));
	}
	
	
	@Test
	public void TestRefreshTot() {
		CarrelloBean carrello = new CarrelloBean();
		ProductBean prodotto = new ProductBean(1, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		
		carrello.addProduct(prodotto);
		carrello.refreshTot();
		assertEquals(12.5, carrello.getPrezzoTot());
	}
	
	@Test
	public void TestGetListaProdotti() {
		CarrelloBean carrello = new CarrelloBean();
		ProductBean prodotto = new ProductBean(1, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		
		carrello.addProduct(prodotto);
		List<ProductBean> lista = carrello.getListaProdotti();
		assertEquals(lista.get(0), prodotto);
	}
	
	@Test
	public void TestSetListaProdotti() {
		CarrelloBean carrello = new CarrelloBean();
		ProductBean prodotto = new ProductBean(1, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		ArrayList<ProductBean> lista = new ArrayList<ProductBean>();
		lista.add(prodotto);
		
		carrello.setListaProdotti(lista);
		assertEquals(carrello.getListaProdotti(), lista);
		
	}
	
	@Test
	public void TestGetPrezzoTot() {
		CarrelloBean carrello = new CarrelloBean();
		carrello.setPrezzoTot(10);
		
		assertEquals(10.0, carrello.getPrezzoTot());
	}
	
	@Test
	public void TestSetPrezzoTot() {
		CarrelloBean carrello = new CarrelloBean();
		carrello.setPrezzoTot(10);
		
		assertEquals(10.0, carrello.getPrezzoTot());
	}
	
}
