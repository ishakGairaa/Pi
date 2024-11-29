package whz.pti.eva.customerManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.customerManagement.domain.DeliveryAddress;
import whz.pti.eva.customerManagement.domain.DeliveryAddressRepository;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

	@Autowired
	private DeliveryAddressRepository deliveryAddressRepository;

	@Override
	public DeliveryAddress createDeliveryAddress(String street, String houseNumber, String town, String postalCode) {
		DeliveryAddress deliveryAddress = new DeliveryAddress(street, houseNumber, town, postalCode);
		return deliveryAddressRepository.save(deliveryAddress);
	}

	@Override
	public void deleteDeliveryAddress(Integer id) {
		deliveryAddressRepository.deleteById(id);
	}

	@Override
	public void updateDeliveryAddress(DeliveryAddress deliveryAddress) {
		deliveryAddressRepository.save(deliveryAddress);
	}

	@Override
	public Optional<DeliveryAddress> getDeliveryAddressById(Integer id) {
		return deliveryAddressRepository.findById(id);
	}
}
