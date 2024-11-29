package whz.pti.eva.pizza.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import whz.pti.eva.common.BaseEntity;
import whz.pti.eva.security.domain.User;

@Entity
public class Cart extends BaseEntity<String>{
	
	private String userid;
	
	private int quantity;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private List<Item> items = new ArrayList<Item>();

	@OneToOne
	@JoinColumn(name = "user_id")
	private User customer;
	
	public Cart() {
	}

	public Cart(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getquantity() {
		return quantity;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void deleteItem(String itemId) {
		for (int i=0 ; i<items.size(); i++) {
			if(items.get(i).getId().equals(itemId)) {
				items.remove(i);
				return;
			}
		}
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(userid);
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
//		Cart other = (Cart) obj;
//		return Objects.equals(userid, other.userid);
//	}
}
