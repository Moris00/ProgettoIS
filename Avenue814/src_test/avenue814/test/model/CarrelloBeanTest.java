package avenue814.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import avenue814.model.*;

public class CarrelloBeanTest {

	
	@Test
	public void addProduct() {
		ProductBean prodotto = new ProductBean(1, "Nike Shoes", 12.5, "Ciaone a tutti", "Maglie", 10, "/path/imag.png", "Donna", true, 123);
		CarrelloBean carrello = new CarrelloBean();
		
		
	}
}
