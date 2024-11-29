package whz.pti.eva.pizzaSelection.boundary;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.cartManagment.service.CartService;
import whz.pti.eva.pizza.domain.Item;
import whz.pti.eva.pizza.domain.Pizza;
import whz.pti.eva.pizza.domain.PizzaSize;
import whz.pti.eva.pizzaSelection.service.PizzaService;

@Controller
public class PizzaSelectionController {

	private static final Logger log = LoggerFactory.getLogger(PizzaSelectionController.class);
	
	@Autowired
	private PizzaService pizzaService;

	//@Autowired
	//private ItemService itemService;

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = {"/","/home"})
	public String listMenu(Model model) {
		List<Pizza> pizzas = pizzaService.listAllPizzas();
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("item", new Item()); // leeres Item-Objekt für das Formular
		return "home"; // HTML Seite, die das Bestellformular anzeigt
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addItemToCart(@RequestParam String quantity, @RequestParam String name, @RequestParam String priceSmall, 
			@RequestParam String priceMedium, @RequestParam String priceLarge, @RequestParam String pizzaSize, Model model) {
		Pizza pizza = new Pizza(name, new BigDecimal(priceSmall), new BigDecimal(priceMedium), new BigDecimal(priceLarge));
		PizzaSize size = PizzaSize.Small;
		switch (pizzaSize.charAt(0)) {
			case 'S': 
				size = PizzaSize.Small; 
				break;
			case 'M': 
				size = PizzaSize.Medium; 
				break;
			case 'L': 
				size = PizzaSize.Large; 
				break;
		}
		Item item = new Item(Integer.valueOf(quantity), pizza, size);
		cartService.addItemToCart("1", item);
		return "redirect:home";
	}
}
//http://localhost:8080/home