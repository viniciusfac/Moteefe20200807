package pt.com.viniciusfac.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import pt.com.viniciusfac.model.Item;

@Service
public class ItemServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Item create(Item item) {
		return item;
	}
	
	public Item update(Item item) {
		return item;
	}	
	
	public void delete(String id) {
		
	}
	
	public Item findById(String id) {
		Item item= new Item();
		
		item.setId(counter.incrementAndGet());
		item.setTitle("Teste");
		item.setQuantity(10);

		return item;
	}
	
	public List<Item> findAll() {
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i < 8; i++) {
			Item item = mockItem(i);
			items.add(item);			
		}
		return items;
	}

	private Item mockItem(int i) {
		Item item = new Item();
		item.setId(counter.incrementAndGet());
		item.setTitle("Teste");
		item.setQuantity(10-1);
		
		return item;
	}

}
