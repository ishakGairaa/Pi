package whz.pti.eva.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import whz.pti.eva.pizza.domain.Cart;
import whz.pti.eva.pizza.domain.CartRepository;
import whz.pti.eva.pizza.domain.ItemRepository;
import whz.pti.eva.pizza.domain.OrderedItemRepository;
import whz.pti.eva.pizza.domain.OrderedRepository;
import whz.pti.eva.pizza.domain.Pizza;
import whz.pti.eva.pizza.domain.PizzaRepository;
import whz.pti.eva.security.domain.User;
import whz.pti.eva.security.domain.UserRepository;

@Service
public class InitializeService {

	private static final Logger logger = LoggerFactory.getLogger(InitializeService.class);
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private OrderedItemRepository orderedItemRepository;

	@Autowired
	private OrderedRepository orderedRepository;

	
	@Transactional
	public void initPizza() {
		logger.info("Initializing pizza data...");

		Pizza pizzaMargherita = new Pizza("Margherita", BigDecimal.valueOf(8.00), BigDecimal.valueOf(9.00),
				BigDecimal.valueOf(18.00));
		Pizza pizzaSalami = new Pizza("Salami", BigDecimal.valueOf(8.00), BigDecimal.valueOf(9.00),
				BigDecimal.valueOf(18.00));
		Pizza pizzaFunghi = new Pizza("Funghi", BigDecimal.valueOf(8.00), BigDecimal.valueOf(9.00),
				BigDecimal.valueOf(18.00));
		Pizza pizzaSchinken = new Pizza("Schinken", BigDecimal.valueOf(8.00), BigDecimal.valueOf(9.00),
				BigDecimal.valueOf(18.00));
		Pizza pizzaHamburger = new Pizza("Hamburger", BigDecimal.valueOf(9.00), BigDecimal.valueOf(10.00),
				BigDecimal.valueOf(23.00));
		Pizza pizzaDoener = new Pizza("Döner mit Zwiebeln", BigDecimal.valueOf(9.00), BigDecimal.valueOf(10.00),
				BigDecimal.valueOf(23.00));
		Pizza pizzaHawaii = new Pizza("Hawaii", BigDecimal.valueOf(9.00), BigDecimal.valueOf(10.00),
				BigDecimal.valueOf(23.00));
		Pizza pizzaChickenHawaii = new Pizza("Chicken Hawaii", BigDecimal.valueOf(9.00), BigDecimal.valueOf(10.00),
				BigDecimal.valueOf(23.00));
		Pizza pizzaVierJahreszeiten = new Pizza("Vier Jahreszeiten", BigDecimal.valueOf(9.00), BigDecimal.valueOf(10.00),
				BigDecimal.valueOf(23.00));
		Pizza pizzaDiavolo = new Pizza("Diavolo", BigDecimal.valueOf(9.00), BigDecimal.valueOf(10.00),
				BigDecimal.valueOf(23.00));
		Pizza pizzaCaprese = new Pizza("Caprese", BigDecimal.valueOf(9.00), BigDecimal.valueOf(10.00),
				BigDecimal.valueOf(23.00));
		Pizza pizzaQuattroFormaggi = new Pizza("Quattro Formaggi", BigDecimal.valueOf(10.00), BigDecimal.valueOf(11.00),
				BigDecimal.valueOf(25.00));
		
		pizzaRepository.save(pizzaMargherita);
		pizzaRepository.save(pizzaSalami);
		pizzaRepository.save(pizzaFunghi);
		pizzaRepository.save(pizzaSchinken);
		pizzaRepository.save(pizzaHamburger);
		pizzaRepository.save(pizzaDoener);
		pizzaRepository.save(pizzaHawaii);
		pizzaRepository.save(pizzaChickenHawaii);
		pizzaRepository.save(pizzaVierJahreszeiten);
		pizzaRepository.save(pizzaDiavolo);
		pizzaRepository.save(pizzaCaprese);
		pizzaRepository.save(pizzaQuattroFormaggi);

		logger.info("Pizza data initialized successfully.");
	}
	
	public void initUser() {
		logger.info("Initializing user data...");
		
		User user = new User();
		user.setLoginname("bnutz");
		user.setPassword("n1");
		user.setFirstName("bnutzFirstName");
		user.setLastName("bnutzLastName");
		user.isActive();
		userRepository.save(user);
		
		User user1 = new User();
		user1.setLoginname("cnutz");
		user1.setPassword("n2");
		user1.setFirstName("cnutzFirstName");
		user1.setLastName("cnutzLastName");
		user1.isActive();
		userRepository.save(user1);
		
		logger.info("User data initialized successfully.");
	}
	
	public void initCart() {
		logger.info("Initializing cart data...");
		Cart cart = new Cart();
		cart.setId("1");
		
		cartRepository.save(cart);
		logger.info("Cart data initialized successfully.");
	}
}
