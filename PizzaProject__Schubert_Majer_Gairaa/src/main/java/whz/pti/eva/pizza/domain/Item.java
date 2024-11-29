package whz.pti.eva.pizza.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import whz.pti.eva.common.BaseEntity;
import jakarta.persistence.Enumerated;

@Entity
public class Item extends BaseEntity<String>{
	
	private String itemId;
	
	private int quantity;
	
	@ManyToOne
	private Pizza pizza;
	
	@Enumerated
	private PizzaSize size;
	
	@ManyToOne
	private Cart cart;
	
	public Item() {
	}
	
	public Item(int quantity, Pizza pizza, PizzaSize size) {
		
	}
	
	public String getItemId() {
		return this.itemId;
	}
	
	public void setItemId(String itemid) {
		this.itemId = itemid;
	}
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Pizza getPizza() {
		return this.pizza;
	}
	
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public PizzaSize getPizzaSize() {
		return size;
	}
	
	public void setPizzaSize(PizzaSize size) {
		this.size = size;
	}
	
	public Item getItem() {
		return this;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(itemid);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Item other = (Item) obj;
//		return Objects.equals(itemid, other.itemid);
//	}
}
