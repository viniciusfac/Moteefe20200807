package pt.com.viniciusfac.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import pt.com.viniciusfac.model.Item;
import pt.com.viniciusfac.model.OrderDelivery;
import pt.com.viniciusfac.model.Shipment;

@Service
public class OrderDeliveryServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public OrderDelivery create(OrderDelivery orderDelivery) {
		return orderDelivery;
	}
	
	public OrderDelivery update(OrderDelivery orderDelivery) {
		return orderDelivery;
	}	
	
	public void delete(String id) {
		
	}
	
	public OrderDelivery findById(String id) {
		OrderDelivery orderDelivery= new OrderDelivery();

		orderDelivery.setId(counter.incrementAndGet());
		orderDelivery.setDeliveryDate(new Date());

		return orderDelivery;
	}
	
	public List<OrderDelivery> findAll() {
		List<OrderDelivery> orderDeliverys = new ArrayList<OrderDelivery>();
		for (int i = 0; i < 8; i++) {
			OrderDelivery orderDelivery = mockOrderDelivery(i);
			orderDeliverys.add(orderDelivery);			
		}
		return orderDeliverys;
	}

	private OrderDelivery mockOrderDelivery(int i) {
		OrderDelivery orderDelivery = new OrderDelivery();
		orderDelivery.setId(counter.incrementAndGet());
		orderDelivery.setDeliveryDate(new Date());
		orderDelivery.setShipments(mockShipments());
		
		return orderDelivery;
	}
	
	public List<Shipment> mockShipments() {
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
	
	public List<Item> mockItems() {
		List<Item> itens = new ArrayList<Item>();
		for (int i = 0; i < 8; i++) {
			Item item = mockItem(i);
			itens.add(item);			
		}
		return itens;
	}

	private Item mockItem(int i) {
		Item item = new Item();
		item.setId(counter.incrementAndGet());
		item.setTitle("Teste");
		item.setQuantity(10-1);
		
		return item;
	}
	
	
}
