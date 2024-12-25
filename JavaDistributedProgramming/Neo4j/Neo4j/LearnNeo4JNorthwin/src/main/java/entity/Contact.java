package entity;

import java.io.Serializable;



public class Contact implements Serializable {
	
	private String contactName;
	private String contactTitle;
	private String fax;
	private String phone;

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(String contactName, String contactTitle, String fax, String phone) {

		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.fax = fax;
		this.phone = phone;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [contactName=" + contactName + ", contactTitle=" + contactTitle + ", fax=" + fax + ", phone="
				+ phone + "]";
	}

}
