package logic.business.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import logic.business.auxiliars.SearchManager;
import logic.business.controllers.AccessController;
import logic.business.controllers.DBController;
import logic.business.controllers.HRController;
import logic.business.controllers.SalesController;
import logic.util.Address;
import logic.util.PositionValue;
import logic.util.ScholarDegreeValue;

public class Store {
	private AccessController accessCtrl;
	private HRController hrCtrl;
	private DBController databaseCtrl;
	private SalesController salesCtrl;
	
	private ArrayList<Worker> workersList;
	private ArrayList<Product> database;
	
	private String name;
	private Address address;
	private String phoneNumber;
	private Worker manager;
	private Date startManagerDate;
	
	public Store(){
		name = new String();
		phoneNumber = new String();
		address = new Address();
		workersList = new ArrayList<Worker>();
		database = new ArrayList<Product>();
		hrCtrl = new HRController("admin", "admin", "admin", ScholarDegreeValue.superior, workersList);
		manager = workersList.get(0);
		startManagerDate = new Date();
		startManagerDate = Calendar.getInstance().getTime();
		accessCtrl = new AccessController(workersList);
		databaseCtrl = new DBController(database);
		salesCtrl = new SalesController(database);
		initialize();
	}
	
	private void initialize(){
		name = "El Cucurucho";
		address.setStreet("114").setLatStreetA("La escalinata").setLatStreetB("La warapera").setNumber("12");
		phoneNumber = "71234567";
		hrCtrl.hireWorker("Pepe", "A", "12345678901", PositionValue.manager, ScholarDegreeValue.basic);
		hrCtrl.hireWorker("Alberto", "A", "12345678901", PositionValue.manager, ScholarDegreeValue.basic);
	}
	
	public AccessController getAccessController(){return accessCtrl;}
	public SalesController getSalesController(){return salesCtrl;}
	
	public String getName(){return name;}
	public void setName(String name){this.name = name;}
	public Address getAddress(){return address;}
	public void setAddress(String street, String latStreetA, String latStreetB, String number){
		this.address.setStreet(street);
		this.address.setLatStreetA(latStreetA);
		this.address.setLatStreetB(latStreetB);
		this.address.setNumber(number);
	}
	public String getPhoneNumber(){return phoneNumber;}
	public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
}
