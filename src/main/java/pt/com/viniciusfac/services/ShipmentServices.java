package pt.com.viniciusfac.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import pt.com.viniciusfac.model.ItemOut;
import pt.com.viniciusfac.model.Shipment;

@Service
public class ShipmentServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Shipment create(Shipment shipment) {
		return shipment;
	}
	
	public Shipment update(Shipment shipment) {
		return shipment;
	}	
	
	public void delete(String id) {
		
	}
	
	public Shipment findById(String id) {
		Shipment shipment= new Shipment();

		shipment.setId(counter.incrementAndGet());
		shipment.setSupplier("Supplier");
		shipment.setDeliveryDate(new Date());

		return shipment;
	}
	
	public List<Shipment> findAll() {
		List<Shipment> shipments = new ArrayList<Shipment>();
		for (int i = 0; i < 8; i++) {
			Shipment shipment = mockShipment(i);
			shipments.add(shipment);			
		}
		return shipments;
	}

	private Shipment mockShipment(int i) {
		Shipment shipment = new Shipment();
		shipment.setId(counter.incrementAndGet());
		shipment.setSupplier("Supplier");
		shipment.setDeliveryDate(new Date());
		shipment.setItem(mockItems());
		
		return shipment;
	}
	
	public List<ItemOut> mockItems() {
		List<ItemOut> itens = new ArrayList<ItemOut>();
		for (int i = 0; i < 8; i++) {
			ItemOut item = mockItem(i);
			itens.add(item);			
		}
		return itens;
	}

	private ItemOut mockItem(int i) {
		ItemOut item = new ItemOut();
		item.setId(counter.incrementAndGet());
		item.setTitle("Teste");
		item.setQuantity(10-1);
		
		return item;
	}
	
	
}
