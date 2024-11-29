package whz.pti.eva.pizza.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import whz.pti.eva.common.BaseEntity;

@Entity
public class Ordered extends BaseEntity<String>{
	
	private String userid;
	
	private int numberOfItems;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ordered")
	private List<OrderedItem> orderedItems = new ArrayList<>();
	
	public Ordered() {
	}

	public Ordered(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public List<OrderedItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<OrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
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
//		Ordered other = (Ordered) obj;
//		return Objects.equals(userid, other.userid);
//	}
}
