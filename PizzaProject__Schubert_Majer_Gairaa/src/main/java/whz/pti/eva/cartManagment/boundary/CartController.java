package whz.pti.eva.cartManagment.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import whz.pti.eva.cartManagment.service.CartService;
import whz.pti.eva.pizza.domain.Item;
import whz.pti.eva.pizza.domain.Pizza;
import whz.pti.eva.pizza.domain.PizzaSize;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;

	@RequestMapping("/cart")
	public String listItems(Model model) {
		List<Item> items = cartService.ListAllItems("1");
		model.addAttribute("items", items);
		return "/cart"; 
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteItem(@RequestParam String itemId, Model model) {
		cartService.deleteItem("1", itemId);
		return "redirect:cart";
	}
	
//	@GetMapping(path = "/sessionId")  
//	public void getSessionId(HttpSession session) {  
//	    String sessionId = session.getId();  
//	}
}
