package pt.com.viniciusfac.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import pt.com.viniciusfac.model.ItemOut;

@Service
public class ItemServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public ItemOut create(ItemOut item) {
		return item;
	}
	
	public ItemOut update(ItemOut item) {
		return item;
	}	
	
	public void delete(String id) {
		
	}
	
	public ItemOut findById(String id) {
		ItemOut item= new ItemOut();
		
		item.setId(counter.incrementAndGet());
		item.setTitle("Teste");
		item.setQuantity(10);

		return item;
	}
	
	public List<ItemOut> findAll() {
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
