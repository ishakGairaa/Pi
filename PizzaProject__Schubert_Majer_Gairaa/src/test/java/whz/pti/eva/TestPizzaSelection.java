package whz.pti.eva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import whz.pti.eva.cartManagment.service.CartService;
import whz.pti.eva.pizza.domain.Pizza;
import whz.pti.eva.pizzaSelection.service.PizzaService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
class TestPizzaSelection {
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@MockBean
	PizzaService pizzaService;
	
	@MockBean
	CartService cartService;
	
	Pizza pizza;
	
	@BeforeEach
	void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		when(cartService.getQuantity("iD")).thenReturn(4);
		Pizza pizza = new Pizza();
	}

	@Test
	void testListMenu() throws Exception{
		mockMvc.perform(get("/home")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param("pizzas","pizza")
				.param("item","item"))
				.andExpect(status().isOk());
	}

	@Test
	public void testAddPizzaToCart() throws Exception {
		mockMvc.perform(post("/add")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param("quantity","1")
				.param("name","Margherita")
				.param("priceSmall","10")
				.param("priceSmall","15")
				.param("priceSmall","20")
				.param("pizzaSize","Medium")
				)
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("home"));
	}
}
