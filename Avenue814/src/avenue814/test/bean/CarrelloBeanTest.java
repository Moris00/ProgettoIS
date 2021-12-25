package avenue814.test.bean;


import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import avenue814.model.CarrelloBean;
import avenue814.model.ProductBean;

public class CarrelloBeanTest {

	@Test
	void testAddProduct() {
		CarrelloBean carrello = new CarrelloBean();
		ProductBean prodotto = new ProductBean(1, "Calzini",10.00, "sono calzini", "Accessori", 2, "", "Uomo", true);
		carrello.addProduct(prodotto);
		
		assertEquals(carrello.searchProduct("Calzini"), prodotto);
	}
	
	@Test
	void testSearchProduct(){
		CarrelloBean carrello = new CarrelloBean();
		ProductBean prodotto = new ProductBean(1, "Calzini",10.00, "sono calzini", "Accessori", 2, "", "Uomo", true);
		carrello.addProduct(prodotto);
		
		ProductBean searchedProduct = carrello.searchProduct("Calzini");
		assertEquals(searchedProduct, prodotto);	
	}
	
	@ParameterizedTest
	@MethodSource("testAddPriceProvider")
	void testAddPrice(double price){
		CarrelloBean carrello = new CarrelloBean();
		double priceInitial = carrello.getPrezzoTot();
		carrello.addPrice(price);
		
		assertEquals(priceInitial, carrello.getPrezzoTot()-price);
		
		
	}
	
	@Test
	void testRefreshPrice() {
		CarrelloBean carrello = new CarrelloBean();
		double price = carrello.getPrezzoTot();
		carrello.refreshTot();
		
		assertEquals(price, carrello.getPrezzoTot());
	}
	
	
	private static Stream<Arguments> testAddPriceProvider(){
		return Stream.of(
				Arguments.of(Double.parseDouble("0")),
				Arguments.of(Double.parseDouble("1")),
				Arguments.of(Double.parseDouble("-1"))
				);
	}
	
}
