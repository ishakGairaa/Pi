package whz.pti.eva.cartManagment.service;

import java.util.List;

import whz.pti.eva.pizza.domain.Cart;
import whz.pti.eva.pizza.domain.Item;
import whz.pti.eva.security.domain.User;

public interface CartService {
	Cart findById(String cartId);
	
	List<Item> ListAllItems(String cartId);
	
	int getQuantity(String cartId);
	
	void addItemToCart(Cart cart, Item item, int quantity);
	
	void updateCart(Cart cart);
	
	public void deleteItem(String cartId,String itemId);
}
