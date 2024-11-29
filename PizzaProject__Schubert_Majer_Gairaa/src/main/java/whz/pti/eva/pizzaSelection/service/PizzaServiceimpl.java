package whz.pti.eva.pizzaSelection.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.pizza.domain.Pizza;
import whz.pti.eva.pizza.domain.PizzaRepository;
import whz.pti.eva.pizza.domain.PizzaSize;

@Service
public class PizzaServiceimpl implements PizzaService {

	private static final Logger log = LoggerFactory.getLogger(PizzaService.class);
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Override
	public List<Pizza> listAllPizzas() {
		return pizzaRepository.findAll();
	}

	@Override
	public Optional<Pizza> getPizzaByName(String name) {
		return pizzaRepository.findByName(name);
	}

	@Override
	public BigDecimal getPriceForSize(String name, PizzaSize size) {
		Optional<Pizza> pizzaOptional = getPizzaByName(name);
        if (pizzaOptional.isPresent()) {
            Pizza pizza = pizzaOptional.get();
            switch (size) {
                case Small:
                    return pizza.getPriceSmall();
                case Medium:
                    return pizza.getPriceMedium();
                case Large:
                    return pizza.getPriceLarge();
                default:
                    throw new IllegalArgumentException("Ungültige Pizza-Größe: " + size);
            }
        } else {
            throw new IllegalArgumentException("Pizza nicht gefunden");
        }
	}
}
