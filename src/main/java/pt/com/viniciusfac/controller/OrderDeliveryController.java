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
	private OrderDeliveryServices service;
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDelivery> findAll() {
		return service.findAll();
	}	
	
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDelivery findById(@PathVariable("id") String id) {
		return service.findById(id);
	}	
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDelivery create(@RequestBody OrderDelivery orderDelivery) {
		return service.create(orderDelivery);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDelivery update(@RequestBody OrderDelivery orderDelivery) {
		return service.update(orderDelivery);
	}	
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}	
	
}