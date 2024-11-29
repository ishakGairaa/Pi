package whz.pti.eva.security.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import whz.pti.eva.common.BaseEntity;
import whz.pti.eva.customerManagement.domain.DeliveryAddress;
import whz.pti.eva.pizza.domain.Cart;

@Entity
@Table(name = "secuser")
public class User extends BaseEntity<Long>{

	private String firstName;
	private String lastName;
	
	private boolean isLoggedIn;
	private boolean active;
	
	@Column(name = "loginname", nullable = false, unique = true)
	private String loginname;
	@Column(name = "password", nullable = false)
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<DeliveryAddress> deliveryAddresses = new ArrayList<DeliveryAddress>();

	@OneToOne(mappedBy = "customer")
	private Cart cart;
	
	public User() {

	}

	public User(String firstName, String lastName, String loginname, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginname = loginname;
		this.password = password;
		this.cart = new Cart();
	}

	public List<DeliveryAddress> getDeliveryAddresses() {
		return deliveryAddresses;
	}

	public void setDeliveryAddresses(List<DeliveryAddress> deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

	public void addDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddresses.add(deliveryAddress);
	}
	
	public void deleteDeliveryAddress(DeliveryAddress deliveryAddress) {
	    Iterator<DeliveryAddress> iterator = deliveryAddresses.iterator();
	    boolean found = false;
	    
	    while (iterator.hasNext()) {
	        DeliveryAddress d = iterator.next();
	        if (d.equals(deliveryAddress)) {
	            iterator.remove();
	            found = true;
	            break;
	        }
	    }
	    
	    if (!found) {
	        System.out.println("Addresse nicht gefunden");
	    }
	}

	@Override
	public Long getId() {
		return super.getId();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwordHash) {
		this.password = passwordHash;
	}

	public List<DeliveryAddress> getDeliveryAddress() {
		return deliveryAddresses;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + getId() + "loginname=" + loginname + ", password='" + password.substring(0, 10)
				 + '}';
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
