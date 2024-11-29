package whz.pti.eva.security.boundary;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.security.domain.CurrentUser;
import whz.pti.eva.security.domain.User;
import whz.pti.eva.security.service.user.UserService;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;

	@Autowired
	private CurrentUser currentUser;
	
/*	@RequestMapping("/login")
	public String getLoginPage(@RequestParam Optional<String> error, Model model) {
		log.debug("Accessing login page");
	    error.ifPresent(e -> log.warn("Login error: {}", e));
	    return "login";
	}*/
	
	@RequestMapping("/login")
	public String getLoginPage(@RequestParam(name = "error", required = false) String error, Model model) {
	    log.debug("Accessing login page");
	    if (error != null) {
	        log.warn("Login error: {}", error);
	    }
	    return "login";
	}
	
	@RequestMapping(value = "/first", method = { RequestMethod.POST })
	public String fistPage(@RequestParam String loginname, @RequestParam String password, Model model) {
		log.debug("Login attempt for user: {}", loginname);

		Optional<User> userOptional = userService.getUserByLoginname(loginname);

		if (!userOptional.isPresent() || !userOptional.get().getPassword().equals(password)) {
			log.warn("Incorrect password for user: {}", loginname);
			model.addAttribute("error", "falscher Login");
			return "login";
		}

		User user = userOptional.get();

		currentUser.setUser(user);
		log.debug("User logged in: {}", loginname);

		return "redirect:/home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model) {
		// user wird aus dem userService geholt.
		Optional<User> userOptional = userService.getUserByLoginname(currentUser.getLoginname());

		// user wird auf null gesetzt, um ihn auszuloggen.
		currentUser.setUser(null);

		return "redirect:/home";
	}
}
