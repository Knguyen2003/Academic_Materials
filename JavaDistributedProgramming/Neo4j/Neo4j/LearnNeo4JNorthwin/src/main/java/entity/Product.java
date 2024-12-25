package entity;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Product implements Serializable {
	@SerializedName("productID")
	private String productID;
	@SerializedName("productName")
	private String productName;

	private transient Supplier supplier;
	private transient Category category;

	private String quantityPerUnit;
	private double unitPrice;
	private int unitsInStock;
	private int unitsOnOrder;
	private boolean discontinued;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(String productID, String productName, Supplier supplier, Category categoryID, String quantityPerUnit,
			double unitPrice, int unitsInStock, int unitsOnOrder, boolean discontinued) {
		
		this.productID = productID;
		this.productName = productName;
		this.supplier = supplier;
		this.category = categoryID;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.discontinued = discontinued;
	}



	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategoryID() {
		return category;
	}

	public void setCategoryID(Category categoryID) {
		this.category = categoryID;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public int getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}



	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", supplier=" + supplier
				+ ", category=" + category + ", quantityPerUnit=" + quantityPerUnit + ", unitPrice=" + unitPrice
				+ ", unitsInStock=" + unitsInStock + ", unitsOnOrder=" + unitsOnOrder + ", discontinued=" + discontinued
				+ "]";
	}



	



	

	

}
