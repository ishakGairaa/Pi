package whz.pti.eva.customerManagement.service;

import java.util.Optional;

import whz.pti.eva.customerManagement.domain.DeliveryAddress;

public interface DeliveryAddressService {

	DeliveryAddress createDeliveryAddress(String street, String houseNumber, String town, String postalCode);
	void updateDeliveryAddress(DeliveryAddress deliveryAddress);
	void deleteDeliveryAddress(Integer id);
	Optional<DeliveryAddress> getDeliveryAddressById(Integer id);
}
