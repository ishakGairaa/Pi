package whz.pti.eva.pizzaSelection.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import whz.pti.eva.pizza.domain.Pizza;
import whz.pti.eva.pizza.domain.PizzaSize;

public interface PizzaService {

	List<Pizza> listAllPizzas();
	
	Optional<Pizza> getPizzaByName(String name);
	
	public BigDecimal getPriceForSize(String name, PizzaSize size);
}
