package whz.pti.eva.security.domain;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import whz.pti.eva.customerManagement.domain.DeliveryAddress;
import whz.pti.eva.pizza.domain.Cart;

@Component
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CurrentUser implements Serializable {

	private User user;
	private String loginname;
	private String password;
	
	private Cart cart;
	
	public CurrentUser() {
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
		if (user != null) {
			this.loginname = user.getLoginname();
			this.password = user.getPassword();
			this.cart = user.getCart();
		}
	}
	
	public Long getId() {
		return user.getId();
	}
	
	public Cart getCart() {
		return user.getCart();
	}
	
	public void setCart(Cart cart) {
		user.setCart(cart);
	}
	
	public String getFirstName() {
		return user.getFirstName();
	}

	public void setFirstName(String firstName) {
		user.setFirstName(firstName);
	}
	
	public String getLastName() {
		return user.getLastName();
	}
	
	public void setLastName(String lastName) {
		user.setLastName(lastName);
	}
	
	public String getLoginname() {
		return user.getLoginname();
	}
	
	public void setStatus(boolean status) {
		user.setActive(status);
	}

	public boolean isActive() {
		if (user.isActive() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addDeliveryAddress(DeliveryAddress newAdress) {
		user.addDeliveryAddress(newAdress);
	}
	
	@Override
	public String toString() {
		return "CurrentUSer{" + "user=" + user + "getFirstname=" + user.getFirstName() + "getLastname="
				+ user.getLastName() + "} " + super.toString();
	}
}
