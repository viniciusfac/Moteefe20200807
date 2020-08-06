package pt.com.viniciusfac.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import pt.com.viniciusfac.model.ItemIn;
import pt.com.viniciusfac.model.ItemOut;
import pt.com.viniciusfac.model.OrderDeliveryIn;
import pt.com.viniciusfac.model.OrderDeliveryOut;
import pt.com.viniciusfac.model.Shipment;

@Service
public class OrderDeliveryServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public OrderDeliveryOut create(OrderDeliveryIn orderDeliveryIn) {
		OrderDeliveryOut orderDelivery = new OrderDeliveryOut();
		
		System.out.println("REGION: " + orderDeliveryIn.getRegion());

		for (ItemIn itemIn : orderDeliveryIn.getBasket().getItems()) {
			System.out.println("Produsct: " + itemIn.getProduct().toString());
			System.out.println("CIOUNT: " + itemIn.getCount());
		}
		
		return orderDelivery;
	}
	
	public OrderDeliveryOut update(OrderDeliveryOut orderDelivery) {
		return orderDelivery;
	}	
	
	public void delete(String id) {
		
	}
	
	public OrderDeliveryOut findById(String id) {
		OrderDeliveryOut orderDelivery= new OrderDeliveryOut();

		orderDelivery.setId(counter.incrementAndGet());
		orderDelivery.setDeliveryDate(new Date());

		return orderDelivery;
	}
	
	public List<OrderDeliveryOut> findAll() {
		List<OrderDeliveryOut> orderDeliverys = new ArrayList<OrderDeliveryOut>();
		for (int i = 0; i < 8; i++) {
			OrderDeliveryOut orderDelivery = mockOrderDelivery(i);
			orderDeliverys.add(orderDelivery);			
		}
		return orderDeliverys;
	}

	private OrderDeliveryOut mockOrderDelivery(int i) {
		OrderDeliveryOut orderDelivery = new OrderDeliveryOut();
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
