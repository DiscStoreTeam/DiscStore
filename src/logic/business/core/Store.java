package logic.business.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import logic.business.controllers.AccessController;
import logic.business.controllers.DBController;
import logic.business.controllers.HRController;
import logic.business.controllers.SalesController;
import logic.util.PositionValue;
import logic.util.ScholarDegreeValue;
import logic.util.StoreProperties;

public class Store {
	private AccessController accessCtrl;
	private HRController hrCtrl;
	private DBController databaseCtrl;
	private SalesController salesCtrl;
	
	private ArrayList<Worker> workersList;
	private ArrayList<Song> songDatabase;
	private ArrayList<Video> videoDatabase;
	
	private Worker manager;
	private Worker loggedWorker;
	private Date startManagerDate;
	private StoreProperties properties;
	
	public Store(){
		properties = new StoreProperties();
		workersList = new ArrayList<Worker>();
		songDatabase = new ArrayList<Song>();
		videoDatabase = new ArrayList<Video>();
		loggedWorker = new Worker();
		hrCtrl = new HRController("admin", "admin", "admin", ScholarDegreeValue.superior, workersList);
		manager = workersList.get(0);
		startManagerDate = new Date();
		startManagerDate = Calendar.getInstance().getTime();
		accessCtrl = new AccessController(workersList, this);
		databaseCtrl = new DBController(songDatabase, videoDatabase);
		salesCtrl = new SalesController(songDatabase, videoDatabase, loggedWorker);
		initialize();
	}
	
	private void initialize(){
		properties.setName("El cucurucho");
		properties.getAddress().setStreet("114").setNumber("12").setLatStreetA("La escalinata").setLatStreetB("La warapera");
		properties.setPhoneNumber("79019090");
		hrCtrl.hireWorker("Pepe", "A", "12345678901", PositionValue.dependent, ScholarDegreeValue.basic);
		hrCtrl.hireWorker("Alberto", "A", "12345678901", PositionValue.dependent, ScholarDegreeValue.basic);
	}
	
	public void updateLoggedWorker(Worker loggedWorker){
		this.loggedWorker = loggedWorker;
		salesCtrl.updateLoggedWorker(this.loggedWorker);
	}
	
	public AccessController getAccessController(){return accessCtrl;}
	public DBController getDatabaseController(){return databaseCtrl;}
	public SalesController getSalesController(){return salesCtrl;}
	public HRController getHumanResourcesController(){return hrCtrl;}
	public StoreProperties getProperties(){return properties;}
}
