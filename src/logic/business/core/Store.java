package logic.business.core;

import java.util.ArrayList;

import logic.business.controllers.AccessController;
import logic.business.controllers.DBController;
import logic.business.controllers.HRController;
import logic.business.controllers.SalesController;
import logic.util.PositionValue;
import logic.util.ScholarDegreeValue;

public class Store {
	private AccessController accessCtrl;
	private HRController hrCtrl;
	private DBController databaseCtrl;
	private SalesController salesCtrl;
	
	private ArrayList<Worker> workersList;
	private ArrayList<Product> database;
	
	public Store(){
		workersList = new ArrayList<Worker>();
		database = new ArrayList<Product>();
		hrCtrl = new HRController("admin", "admin", "admin", ScholarDegreeValue.superior, workersList);
		accessCtrl = new AccessController(workersList);
		databaseCtrl = new DBController(database);
		salesCtrl = new SalesController(database);
		initialize();
	}
	
	private void initialize(){
		hrCtrl.hireWorker("Pepe", "A", "12345678901", PositionValue.manager, ScholarDegreeValue.basic);
		hrCtrl.hireWorker("Alberto", "A", "12345678901", PositionValue.manager, ScholarDegreeValue.basic);
	}
	
	public AccessController getAccessController(){return accessCtrl;}
}
