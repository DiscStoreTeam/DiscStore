package logic.business.controllers;

import java.util.ArrayList;

import logic.business.Worker;
import logic.util.PositionValue;

public class HRController {
	private ArrayList<Worker> workersList;
	private Worker manager;
	
	//Builders
	public HRController(ArrayList<Worker> workersList, Worker manager)
	{
		this.workersList = workersList;
		this.manager = manager;
	}
	
	//Methods
	public void changeManager(int worker ,PositionValue newPosition){
		manager.setPosition(newPosition);
		workersList.get(worker).setPosition(PositionValue.manager);
		manager = workersList.get(worker);
	}
}
