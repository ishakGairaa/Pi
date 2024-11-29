package whz.pti.eva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import whz.pti.eva.service.InitializeService;

@SpringBootApplication
public class PizzaProjectSchubertMajerGairaaApplication {

	private static final Logger log = LoggerFactory.getLogger(PizzaProjectSchubertMajerGairaaApplication.class);
	
	@Autowired
	InitializeService initializeService;
	
	public static void main(String[] args) {
		SpringApplication.run(PizzaProjectSchubertMajerGairaaApplication.class);
	}
	
	@Bean
	CommandLineRunner init() {
		return (evt) -> {
			System.out.println("Pizza-Lieferservice");
			initializeService.initPizza();
			initializeService.initUser();
		};
	}
}
