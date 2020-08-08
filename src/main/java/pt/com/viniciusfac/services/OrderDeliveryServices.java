package pt.com.viniciusfac.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import pt.com.viniciusfac.model.ItemIn;
import pt.com.viniciusfac.model.ItemOut;
import pt.com.viniciusfac.model.OrderDeliveryIn;
import pt.com.viniciusfac.model.OrderDeliveryOut;
import pt.com.viniciusfac.model.Shipment;
import pt.com.viniciusfac.model.Supplier;

@Service
public class OrderDeliveryServices {
	
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
		
		String supplierName = "";
		String supplierNameOld = "";
		Integer supplierIndex = -1;
		Integer deliveryTime = 0;
		Integer deliveryTimeOld = 999;
		Date deliveryDate = new Date();
		Date deliveryDateTemp = new Date();
		
		for (ItemIn itemIn : items) {
			
			String productName = itemIn.getProduct().toString();
			Integer productQtd = itemIn.getCount();

			for (Map.Entry<Integer, List<String>> supplierMap : Supplier.getSupplierMap().entrySet()) {
	            
				List<String> supplier = supplierMap.getValue();

				if (supplier.contains(productName)) {

					supplierName = supplier.get(1);

					deliveryTime = getDeliveryTime(supplier, region);
	
					//TODO: if in_stock < count then look for another supplier
					//Integer.parseInt(values.get(5)) >= itemIn.getCount()
					
	            	if (deliveryTime > deliveryTimeOld) {
	            		supplierName = supplierNameOld;
	            		deliveryTime = deliveryTimeOld;
	            	}

					deliveryDateTemp = getDeliveryDate(deliveryTime);

	            	supplierNameOld = supplierName;
	            	deliveryTimeOld = deliveryTime;

	            }
			}

			if (!supplierName.isEmpty()
					&& deliveryTime > 0 ) {
				
				//TODO: setQuantity the total qtd for that supplier
				ItemOut itemOut = new ItemOut();
				itemOut.setTitle(productName);
				itemOut.setQuantity(productQtd);

				supplierIndex = getSupplierIndex(shipments, supplierName);
				
				//If supplier already exists, just add a new item
				//else create a new supplier
				if (supplierIndex >= 0) {

					if (deliveryDateTemp.after(shipments.get(supplierIndex).getDeliveryDate())) {
						shipments.get(supplierIndex).setDeliveryDate(deliveryDateTemp);
					}
					
					shipments.get(supplierIndex).getItems().add(itemOut);

				}else {
					
					Shipment shipment = new Shipment();
					shipment.setSupplier(supplierName);
					
					shipment.setDeliveryDate(deliveryDateTemp);

					List<ItemOut> itemsOut = new ArrayList<ItemOut>();
					itemsOut.add(itemOut);

					shipment.setItems(itemsOut);
					
					shipments.add(shipment);
					
				}

			}

			supplierNameOld = "";
			deliveryTimeOld = 999;
			
		}

		if (deliveryDateTemp.after(deliveryDate)) {
			deliveryDate = deliveryDateTemp;
		}
		
		orderDeliveryOut.setDeliveryDate(deliveryDate);
		orderDeliveryOut.setShipments(shipments);
		
		return orderDeliveryOut;
	}

	private Integer getDeliveryTime(List<String> supplier, String region) {
		Integer deliveryTime = 0;

    	if ("eu".equalsIgnoreCase(region)){
    		deliveryTime = Integer.parseInt(supplier.get(2));
    	}else if ("us".equalsIgnoreCase(region)){
    		deliveryTime = Integer.parseInt(supplier.get(3));
    	}else if ("uk".equalsIgnoreCase(region)){
    		deliveryTime = Integer.parseInt(supplier.get(4));
    	}

		return deliveryTime;
	}
	
	private Date getDeliveryDate(Integer deliveryTime) {
		Calendar c = Calendar.getInstance();

		c.setTime(new Date());
		c.add(Calendar.DATE, deliveryTime);

		return c.getTime();
	}
	
	private Integer getSupplierIndex(List<Shipment> shipments, String supplier ) {

		Integer supplierIndex = -1;

		if (shipments.isEmpty() || supplier.isEmpty()) {
			return -1;
		}
		
		for (int i = 0; i < shipments.size(); i++) {
			if(shipments.get(i).getSupplier().equalsIgnoreCase(supplier)) {
				supplierIndex = i;
				break;
			}
		}

		return supplierIndex;

	}
	
	/* MOCK METHODS from this point on */
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
		item.setTitle("Teste");
		item.setQuantity(10-1);
		
		return item;
	}
	
}
