package pt.com.viniciusfac.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Basket{

	@Autowired
	@JsonProperty("items")
	private List<ItemOut> items;

	public Basket() {
	}

	public List<ItemOut> getItems() {
		return items;
	}

	public void setItems(List<ItemOut> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Basket other = (Basket) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

}