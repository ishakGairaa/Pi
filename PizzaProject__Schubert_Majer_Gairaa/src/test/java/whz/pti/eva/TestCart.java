package whz.pti.eva;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import whz.pti.eva.pizza.domain.Cart;
import whz.pti.eva.pizza.domain.Item;
import whz.pti.eva.pizza.domain.Pizza;
import whz.pti.eva.pizza.domain.PizzaSize;

class TestCart {
	Cart cart;
	Item item;
	
	@BeforeEach
	void setUp() throws Exception {
		cart = new Cart();
		item = new Item(1,new Pizza(),PizzaSize.Small);
		
	}

	@Test
	void testAddItem() {
		cart.addItem(item);
		assertTrue(cart.getItems().contains(item));
	}
	
	@Test
	void testDeleteItem() {
		item.setId("1");
		cart.addItem(item);
		assertTrue(cart.getItems().contains(item));
		cart.deleteItem("1");
		assertFalse(cart.getItems().contains(item));
	}

}
