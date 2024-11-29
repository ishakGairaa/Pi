package whz.pti.eva.pizza.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import whz.pti.eva.common.BaseEntity;

@Entity
public class OrderedItem extends BaseEntity<Long>{
	
	private Long pizzaid;

	private int quantity;
	
	private String name;
	
	private String userid;
	
	@Enumerated
	private PizzaSize size;
	
	@ManyToOne
	private Ordered ordered;
	
	public OrderedItem() {
	}
	
	public OrderedItem(int quantity, String name, String userid, Ordered ordered, PizzaSize size) {
		this.quantity = quantity;
		this.name = name;
		this.userid = userid;
		this.ordered = ordered;
		this.size = size;
	}
	
	public Long getPizzaId() {
		return pizzaid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public Ordered getOrdered() {
		return ordered;
	}

	public void setOrdered(Ordered ordered) {
		this.ordered = ordered;
	}

	public void setSize(PizzaSize size) {
		this.size = size;
	}

	public PizzaSize getSize() {
		return size;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(pizzaid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderedItem other = (OrderedItem) obj;
		return Objects.equals(pizzaid, other.pizzaid);
	}
}
