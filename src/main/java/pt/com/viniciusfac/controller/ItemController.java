package pt.com.viniciusfac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.com.viniciusfac.model.ItemOut;
import pt.com.viniciusfac.services.ItemServices;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemServices service;
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemOut> findAll() {
		return service.findAll();
	}	
	
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemOut findById(@PathVariable("id") String id) {
		return service.findById(id);
	}	
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemOut create(@RequestBody ItemOut item) {
		return service.create(item);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemOut update(@RequestBody ItemOut item) {
		return service.update(item);
	}	
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}	
	
}