package pt.com.viniciusfac.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import pt.com.viniciusfac.model.ItemIn;
import pt.com.viniciusfac.model.ItemOut;
import pt.com.viniciusfac.model.OrderDeliveryIn;
import pt.com.viniciusfac.model.OrderDeliveryOut;
import pt.com.viniciusfac.model.Shipment;
import pt.com.viniciusfac.model.Supplier;

@Service
public class OrderDeliveryServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public OrderDeliveryOut create(OrderDeliveryIn orderDeliveryIn) {
		OrderDeliveryOut orderDeliveryOut = new OrderDeliveryOut();

		String region = orderDeliveryIn.getRegion();

		List<ItemIn> items = new ArrayList<ItemIn>();
		items = orderDeliveryIn.getBasket().getItems();

		orderDeliveryOut = getOrderDeliveryOut(region, items);

		return orderDeliveryOut;
	}

	private OrderDeliveryOut getOrderDeliveryOut(String region, List<ItemIn> items ) {
		OrderDeliveryOut orderDeliveryOut = new OrderDeliveryOut();
		List<Shipment> shipments = new ArrayList<Shipment>();
		
		String supplier = "";
		String supplierOld = "";
		Integer deliveryTime = 0;
		Integer deliveryTimeOld = 999;
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		Date deliveryDate = new Date();
		
		for (ItemIn itemIn : items) {
		
			for (Map.Entry<Integer, List<String>> entry : Supplier.getSupplierMap().entrySet()) {
	            
				List<String> values = entry.getValue();
				
				//TODO: set all itens from a supplier to its json hierarchy
				//TODO: use the latest date of items to be the delivery date for the supplier
				if (values.contains(itemIn.getProduct().toString())) {
	
					//TODO: if in_stock < count then look for another supplier
					//Integer.parseInt(values.get(5)) >= itemIn.getCount()
	
	            	supplier = values.get(1);
	            	
	            	if ("eu".equalsIgnoreCase(region)){
	            		deliveryTime = Integer.parseInt(values.get(2));
	            	}else if ("us".equalsIgnoreCase(region)){
	            		deliveryTime = Integer.parseInt(values.get(3));
	            	}else if ("uk".equalsIgnoreCase(region)){
	            		deliveryTime = Integer.parseInt(values.get(4));
	            	}
	
	            	if (deliveryTime > deliveryTimeOld) {
	            		supplier = supplierOld;
	            		deliveryTime = deliveryTimeOld;
	            	}
	
	            	supplierOld = supplier;
	            	deliveryTimeOld = deliveryTime;
	
	            }
			}
			
			if (!supplier.isEmpty()
					&& deliveryTime > 0 ) {
				
				Shipment shipment = new Shipment();
				shipment.setSupplier(supplier);

				c.setTime(currentDate);
				c.add(Calendar.DATE, deliveryTime);
				shipment.setDeliveryDate(c.getTime());

				if (shipment.getDeliveryDate().after(deliveryDate)) {
					deliveryDate = shipment.getDeliveryDate();
				}
				
				
				List<ItemOut> itemsOut = new ArrayList<ItemOut>();
				ItemOut itemOut = new ItemOut();
				itemOut.setTitle(itemIn.getProduct().toString());
				itemOut.setQuantity(itemIn.getCount());
				itemsOut.add(itemOut);
				
				shipment.setItems(itemsOut);
				
				shipments.add(shipment);
				
			}
			
			supplierOld = "";
			deliveryTimeOld = 999;
			
		}
		
		orderDeliveryOut.setDeliveryDate(deliveryDate);
		orderDeliveryOut.setShipments(shipments);
		
		return orderDeliveryOut;
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
		shipment.setItems(mockItems());
		
		return shipment;
	}	
	
	public List<ItemOut> mockItems() {
		List<ItemOut> items = new ArrayList<ItemOut>();
		for (int i = 0; i < 8; i++) {
			ItemOut item = mockItem(i);
			items.add(item);			
		}
		return items;
	}

	private ItemOut mockItem(int i) {
		ItemOut item = new ItemOut();
		item.setId(counter.incrementAndGet());
		item.setTitle("Teste");
		item.setQuantity(10-1);
		
		return item;
	}
	
	
}
