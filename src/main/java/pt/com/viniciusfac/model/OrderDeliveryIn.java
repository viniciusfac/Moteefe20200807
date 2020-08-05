package pt.com.viniciusfac.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "region", "basket" })
public class OrderDeliveryIn{

	private String region;	
	
	@Autowired
	@JsonProperty("basket")
	private List<Basket> baskets;

	public OrderDeliveryIn() {
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Basket> getBaskets() {
		return baskets;
	}

	public void setBaskets(List<Basket> baskets) {
		this.baskets = baskets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baskets == null) ? 0 : baskets.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
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
		OrderDeliveryIn other = (OrderDeliveryIn) obj;
		if (baskets == null) {
			if (other.baskets != null)
				return false;
		} else if (!baskets.equals(other.baskets))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}

}