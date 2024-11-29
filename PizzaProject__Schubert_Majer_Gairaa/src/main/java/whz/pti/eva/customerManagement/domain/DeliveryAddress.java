package whz.pti.eva.customerManagement.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import whz.pti.eva.common.BaseEntity;
import whz.pti.eva.security.domain.User;

@Entity
public class DeliveryAddress extends BaseEntity<Integer>{

	private Integer id;

	private String street;
	private String houseNumber;
	private String town;
	private String postalCode;
	
	@ManyToMany(mappedBy = "deliveryAddresses")
	private List<User> registeredCustomers;	
	
	public DeliveryAddress() {
		
	}
	
	public DeliveryAddress(String street, String houseNumber, String town, String postalCode) {
		this.street = street.trim();
		this.houseNumber = houseNumber.trim();
		this.town = town.trim();
		this.postalCode = postalCode.trim();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;	
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	public String getTown() {
		return town;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
}

