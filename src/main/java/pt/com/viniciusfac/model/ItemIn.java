package pt.com.viniciusfac.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({ "produsct", "ciount" })
public class ItemIn{

	@JsonProperty("produsct")
	private String product;

	@JsonProperty("ciount")
	private int count;

	public ItemIn() {
	}

	public String getProdusct() {
		return product;
	}

	public void setProdusct(String produsct) {
		this.product = produsct;
	}

	public int getCiount() {
		return count;
	}

	public void setCiount(int ciount) {
		this.count = ciount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		ItemIn other = (ItemIn) obj;
		if (count != other.count)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

}