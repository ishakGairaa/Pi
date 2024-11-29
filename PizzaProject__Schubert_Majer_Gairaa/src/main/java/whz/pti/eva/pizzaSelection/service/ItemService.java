package whz.pti.eva.pizzaSelection.service;

import whz.pti.eva.pizza.domain.Item;
import whz.pti.eva.pizza.domain.Pizza;
import whz.pti.eva.pizza.domain.PizzaSize;

public interface ItemService {

	public Item createItem(int quantity, Pizza pizza, PizzaSize ps);

	public void updateItem(Item item);

	public void deleteItem(Long itemId);
}
