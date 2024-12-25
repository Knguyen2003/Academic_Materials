package entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class Address implements Serializable{
	private String address;
    private String city;
    private String country;
    private String postalCode;
    private String region;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Address(String address, String city, String country, String postalCode, String region) {
		
		this.address = address;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.region = region;
	}
    
    public Address() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", country=" + country + ", postalCode=" + postalCode
				+ ", region=" + region + "]";
	}
    
    
}
