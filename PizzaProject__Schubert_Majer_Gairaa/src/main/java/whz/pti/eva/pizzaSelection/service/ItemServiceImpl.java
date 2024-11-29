package whz.pti.eva.pizzaSelection.service;

import org.springframework.beans.factory.annotation.Autowired;

import whz.pti.eva.pizza.domain.Item;
import whz.pti.eva.pizza.domain.ItemRepository;
import whz.pti.eva.pizza.domain.Pizza;
import whz.pti.eva.pizza.domain.PizzaSize;

public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item createItem(int quantity, Pizza pizza, PizzaSize ps) {
		Item item = new Item(quantity, pizza, ps);
		return itemRepository.save(item);
	}

	@Override
	public void updateItem(Item item) {
		itemRepository.save(item);	
	}

	@Override
	public void deleteItem(Long itemId) {
		//TODO	
	}

}
