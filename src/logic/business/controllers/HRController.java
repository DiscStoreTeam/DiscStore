package logic.business.controllers;

import java.util.ArrayList;

import logic.business.Worker;
import logic.util.PositionValue;
import logic.util.ScholarDegreeValue;

public class HRController {
	private ArrayList<Worker> workersList;
	private Worker manager;
	
	//Builders
	public HRController(ArrayList<Worker> workersList, Worker manager)
	{
		this.workersList = workersList;
		this.manager = manager;
		fixWorkerList();
	}
	
	//Methods
	public void changeManager(int worker ,PositionValue newPosition){
		manager.setPosition(newPosition);
		workersList.get(worker).setPosition(PositionValue.manager);
		manager = workersList.get(worker);
	}
	
	public void hireWorker(String name, String lastName, String ci, PositionValue position, ScholarDegreeValue scholarDegree)
	{
		Worker hiredWorker = new Worker(name, lastName, ci, generateID(position), position, scholarDegree);
		workersList.add(hiredWorker);
		//sortWorkersList();
		fixWorkerList();
	}
	
	private void fixWorkerList()
	{
		for(int i = 0; i < workersList.size(); i++){
			if(i != 0){
				workersList.get(i).setWorkerID(workersList.get(i - 1).getWorkerID() + 1);
			}
			else{
				workersList.get(i).setWorkerID(0);
			}
		}
	}
	
	private Integer generateID(PositionValue position)
	{
		return workersList.size();
	}
}
