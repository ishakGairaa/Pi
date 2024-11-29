package whz.pti.eva;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import whz.pti.eva.customerManagement.domain.DeliveryAddress;
import whz.pti.eva.customerManagement.domain.DeliveryAddressRepository;
import whz.pti.eva.customerManagement.service.DeliveryAddressServiceImpl;

class DeliveryAddressServiceImplTest {

    @Mock
    private DeliveryAddressRepository deliveryAddressRepository;

    @InjectMocks
    private DeliveryAddressServiceImpl deliveryAddressService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    // Sie Prüft Lieferadresse --korrekt-- erstellt wird.
    @Test
    void testCreateDeliveryAddress() {
      
        String street = "Innere Schneeberger";
        String houseNumber = "23";
        String town = "zwickau";
        String postalCode = "12345";
        DeliveryAddress address = new DeliveryAddress(street, houseNumber, town, postalCode);
        when(deliveryAddressRepository.save(any(DeliveryAddress.class))).thenReturn(address);
        DeliveryAddress result = deliveryAddressService.createDeliveryAddress(street, houseNumber, town, postalCode);
        assertNotNull(result);
        assertEquals(street, result.getStreet());
        assertEquals(houseNumber, result.getHouseNumber());
        assertEquals(town, result.getTown());
        assertEquals(postalCode, result.getPostalCode());
        verify(deliveryAddressRepository, times(1)).save(any(DeliveryAddress.class));
    }

    //  Abrufen einer Lieferadresse bei "id".
    @Test
    void testGetDeliveryAddressById() {
        int id = 1;
        DeliveryAddress address = new DeliveryAddress("Innere Schneeberger", "23", "zwickau", "12345");
        when(deliveryAddressRepository.findById(id)).thenReturn(Optional.of(address));
        Optional<DeliveryAddress> result = deliveryAddressService.getDeliveryAddressById(id);
        assertTrue(result.isPresent());
        assertEquals("Innere Schneeberger", result.get().getStreet());
        verify(deliveryAddressRepository, times(1)).findById(id);
    }
    
    //  Update Lieferadresse.
    @Test
    void testUpdateDeliveryAddress() {
        DeliveryAddress address = new DeliveryAddress("Goethe", "10", "Leipzig", "67890");
        address.setStreet("Updated Street");
        when(deliveryAddressRepository.save(address)).thenReturn(address);
        deliveryAddressService.updateDeliveryAddress(address);
        verify(deliveryAddressRepository, times(1)).save(address);
    }
    // Lieferadresse bei  "id" gelöscht .
    @Test
    void testDeleteDeliveryAddress() {
        int id = 1;
        doNothing().when(deliveryAddressRepository).deleteById(id);
        deliveryAddressService.deleteDeliveryAddress(id);
        verify(deliveryAddressRepository, times(1)).deleteById(id);
    }
}
