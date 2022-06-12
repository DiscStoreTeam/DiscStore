package logic.util;

public class StoreProperties {
	private String name;
	private Address address;
	private String phoneNumber;
	
	public StoreProperties(){
		address = new Address();
		name = new String();
		phoneNumber = new String();
	}
	public StoreProperties(String name, String phoneNumber, Address address){
		this.name = new String(name);
		this.phoneNumber = new String(phoneNumber);
		this.address = new Address(new String(address.getStreet()), new String(address.getNumber()), new String(address.getLatStreetA()), new String(address.getLatStreetB()));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
