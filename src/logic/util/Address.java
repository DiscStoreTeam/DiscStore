package logic.util;

public class Address {
	private String street;
	private String number;
	private String latStreetA;
	private String latStreetB;

	public Address(String street, String number, String latStreetA, String latStreetB) {
		this.street = street;
		this.number = number;
		this.latStreetA = latStreetA;
		this.latStreetB = latStreetB;
	}

	public String getFullAddress()
	{
		return street + " #" + number + " e/ " + latStreetA + " y " + latStreetB; 
	}

	public String getStreet() {
		return street;
	}

	public String getNumber() {
		return number;
	}

	public String getLatStreetA() {
		return latStreetA;
	}

	public String getLatStreetB() {
		return latStreetB;
	}

	public Address setStreet(String street) {
		this.street = street;
		return this;
	}

	public Address setNumber(String number) {
		this.number = number;
		return this;
	}

	public Address setLatStreetA(String latStreetA) {
		this.latStreetA = latStreetA;
		return this;
	}

	public Address setLatStreetB(String latStreetB) {
		this.latStreetB = latStreetB;
		return this;
	}
}
