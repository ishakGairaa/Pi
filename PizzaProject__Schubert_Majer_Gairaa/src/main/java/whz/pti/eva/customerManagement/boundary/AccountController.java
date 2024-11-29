package whz.pti.eva.customerManagement.boundary;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.customerManagement.domain.DeliveryAddress;
import whz.pti.eva.customerManagement.service.DeliveryAddressService;
import whz.pti.eva.security.domain.CurrentUser;
import whz.pti.eva.security.domain.User;
import whz.pti.eva.security.domain.UserRepository;
import whz.pti.eva.security.service.user.UserService;

@Controller
public class AccountController {

	@Autowired
	private UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CurrentUser currentUser;
	
	@Autowired
	private DeliveryAddressService deliveryAddressService;
	
	@GetMapping("/account")
	public String viewAccount(Model model, Principal principal) {
	    
		String currentlyLoggedInLoginname = currentUser.getLoginname();

		User user = userService.getUserByLoginname(currentlyLoggedInLoginname).get();

		if (user != null) {
			model.addAttribute("customer", user);
			return "account";
		} else {
			return "redirect:/home";
		}
	}
	
	@PostMapping("/updateName")
	public String updateName(@ModelAttribute("customer") User user, @RequestParam String newFirstName,
			@RequestParam String newLastName) {

		String currentlyLoggedInUsername = currentUser.getLoginname();
		User u = userService.getUserByLoginname(currentlyLoggedInUsername).get();

		if (!newFirstName.trim().equals("")) {
			u.setFirstName(newFirstName);
		}
		if (!newLastName.trim().equals("")) {
			u.setLastName(newLastName);
		}
		userService.updateCustomer(u);

		return "redirect:/account";

	}
	
	@PostMapping("/addAddress")
	public String addAddress(@ModelAttribute("customer") User user, @RequestParam String street,
			@RequestParam String houseNumber, @RequestParam String postalCode, @RequestParam String town) {
		// Service aufrufen, um eine neue Lieferadresse hinzuzufügen
		DeliveryAddress newAddress = deliveryAddressService.createDeliveryAddress(street, houseNumber, town,
				postalCode);

		String currentlyLoggedInUsername = currentUser.getLoginname();
		User u = userService.getUserByLoginname(currentlyLoggedInUsername).get();

		u.addDeliveryAddress(newAddress);
		userService.updateCustomer(u);

		return "redirect:/account";
	}

	@PostMapping("/toggleStatus")
	public String toggleStatus(@ModelAttribute("customer") User user) {

		String currentlyLoggedInUsername = currentUser.getLoginname();
		User u = userService.getUserByLoginname(currentlyLoggedInUsername).get();
		// Status umkehren
		if (u.isActive() == true) {
			currentUser.setStatus(false);
		} else {
			currentUser.setStatus(true);
		}
		userService.updateCustomer(u);
		return "redirect:/account";
	}
}
