package pt.com.viniciusfac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.com.viniciusfac.model.OrderDeliveryIn;
import pt.com.viniciusfac.model.OrderDeliveryOut;
import pt.com.viniciusfac.services.OrderDeliveryServices;

@RestController
@RequestMapping("/orderdelivery")
public class OrderDeliveryController {
	
	@Autowired
	private OrderDeliveryServices service;
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDeliveryOut> findAll() {
		return service.findAll();
	}	
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDeliveryOut create(@RequestBody OrderDeliveryIn orderDeliveryIn) throws Exception {
		return service.create(orderDeliveryIn);
	}
	
}