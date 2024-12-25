package entity;

import com.google.gson.annotations.SerializedName;

public class Customer implements java.io.Serializable {
    @SerializedName("customerID")
	private String id;
    @SerializedName("companyName")
	private String companyName;
    
	private transient Contact contact;
	private transient Address address;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, String companyName, Contact contact, Address address) {
		this.id = id;
		this.companyName = companyName;
		this.contact = contact;
		this.address = address;
	}
	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", companyName=" + companyName + ", contact=" + contact + ", address=" + address
				+ "]";
	}

}
