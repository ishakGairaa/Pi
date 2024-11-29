package whz.pti.eva.pizza.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import whz.pti.eva.common.BaseEntity;

@Entity
public class Pizza extends BaseEntity<Long> implements Serializable {
	
	private String name;
	
	private BigDecimal priceLarge;
	private BigDecimal priceMedium;
	private BigDecimal priceSmall;
	
	@OneToMany(cascade = CascadeType.PERSIST) // Änderung erst bei neuen Item-Objekten sichtbar
	private List<Item> items = new ArrayList<Item>();
	
	public Pizza() {
	}
	
	public Pizza(String name, BigDecimal priceSmall, BigDecimal priceMedium, BigDecimal priceLarge) {
		this.name = name;
		this.priceSmall = priceSmall;
		this.priceMedium = priceMedium;
		this.priceLarge = priceLarge;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPriceLarge(BigDecimal priceLarge) {
		this.priceLarge = priceLarge;
	}

	public BigDecimal getPriceLarge() {
		return priceLarge;
	}

	public void setPriceMedium(BigDecimal priceMedium) {
		this.priceMedium = priceMedium;
	}

	public BigDecimal getPriceMedium() {
		return priceMedium;
	}

	public void setPriceSmall(BigDecimal priceSmall) {
		this.priceSmall = priceSmall;
	}

	public BigDecimal getPriceSmall() {
		return priceSmall;
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
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
//		Pizza other = (Pizza) obj;
//		return Objects.equals(id, other.id);
//	}
}
