package pt.com.viniciusfac.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "delivery_date", "shipments" })
public class OrderDeliveryOut{
	
	@JsonProperty("delivery_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date deliveryDate;
	
	@Autowired
	@JsonProperty("shipments")
	private List<Shipment> shipments;

	public OrderDeliveryOut() {
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((shipments == null) ? 0 : shipments.hashCode());
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
		OrderDeliveryOut other = (OrderDeliveryOut) obj;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (shipments == null) {
			if (other.shipments != null)
				return false;
		} else if (!shipments.equals(other.shipments))
			return false;
		return true;
	}

}