package whz.pti.eva.cartManagment.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizza.domain.Cart;
import whz.pti.eva.pizza.domain.CartRepository;
import whz.pti.eva.pizza.domain.Item;
import whz.pti.eva.security.domain.User;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart findById(String id) {
		return cartRepository.findById(id).get();
	}

	@Override
	public List<Item> ListAllItems(String id) {
		return cartRepository.findById(id).get().getItems();
	}

	@Override
	public int getQuantity(String id) {
		return cartRepository.findById(id).get().getquantity();
	}

	@Override
	public void addItemToCart(String cartId,Item item) {
		cartRepository.findById(cartId).get().addItem(item);
	}
	
	@Override
	public void deleteItem(String cartId,String itemId) {
		cartRepository.findById(cartId).get().deleteItem(itemId);
	}
}
