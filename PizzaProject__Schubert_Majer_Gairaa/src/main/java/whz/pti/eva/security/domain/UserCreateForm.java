package whz.pti.eva.security.domain;

import jakarta.validation.constraints.NotEmpty;
import whz.pti.eva.pizza.domain.Cart;

public class UserCreateForm {

	@NotEmpty
	private String firstName = "";

	@NotEmpty
	private String lastName = "";

	@NotEmpty
	private String loginname = "";

	@NotEmpty
	private String password = "";

	@NotEmpty()
	private String passwordRepeated = "";

	private Cart cart = null;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName.trim();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName.trim();
	}
	
	public String getLoginname() {
		return loginname;
	}
	
	public void setLoginname() {
	 this.loginname = loginname.trim();	
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password.trim();
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated.trim();
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	@Override
	public String toString() {
		return "CustomerCreateForm{" + "password=***" + '\'' + ", passwordRepeated=***" + '\''
				+ ", loginname=" + loginname + '}';
	}
}
