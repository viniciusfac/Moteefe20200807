package pt.com.viniciusfac.model;

import java.util.Date;


public class ItemSupplier{

	private String productName;

	private int productQtd;
	
	private String supplierName;
	
	private int inStock;
	
	private int stockUsed;
	
	private Date deliveryDate;
	
	public ItemSupplier() {
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQtd() {
		return productQtd;
	}

	public void setProductQtd(int productQtd) {
		this.productQtd = productQtd;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public int getStockUsed() {
		return stockUsed;
	}

	public void setStockUsed(int stockUsed) {
		this.stockUsed = stockUsed;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}