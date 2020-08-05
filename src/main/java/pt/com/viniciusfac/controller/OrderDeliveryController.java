package pt.com.viniciusfac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.com.viniciusfac.model.OrderDelivery;
import pt.com.viniciusfac.services.OrderDeliveryServices;

@RestController
@RequestMapping("/orderdelivery")
public class OrderDeliveryController {
	
	@Autowired
	private OrderDeliveryServices orderDelivery;
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDelivery> findAll() {
		return orderDelivery.findAll();
	}	
	
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDelivery findById(@PathVariable("id") String id) {
		return orderDelivery.findById(id);
	}	
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDelivery create(@RequestBody OrderDelivery shipment) {
		return orderDelivery.create(shipment);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDelivery update(@RequestBody OrderDelivery shipment) {
		return orderDelivery.update(shipment);
	}	
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		orderDelivery.delete(id);
	}	
	
}