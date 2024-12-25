package entity;

import java.io.Serializable;



public class Supplier implements Serializable {
	private String supplierID;
	private String companyName;

	public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public Supplier(String supplierID, String companyName) {

		this.supplierID = supplierID;
		this.companyName = companyName;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Supplier [supplierID=" + supplierID + ", companyName=" + companyName + "]";
	}

}
