package logic.business.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import logic.business.Worker;
import logic.util.PositionValue;
import logic.util.ScholarDegreeValue;

public class HRController {
	private ArrayList<Worker> workersList;
	private Worker manager;
	
	//Builders
	public HRController(String name, String lastName, String ci, ScholarDegreeValue scholarDegree)
	{
		this.workersList = new ArrayList<Worker>();
		this.manager = new Worker(name, lastName, ci, 0, PositionValue.manager, scholarDegree);
		workersList.add(manager);
	}
	
	public HRController(ArrayList<Worker> workersList)
	{
		this.workersList = new ArrayList<Worker>(workersList);
		this.manager = new Worker(workersList.get(0));
	}
	
	//Methods
	public void changeManager(int newManagerPosition){
		Worker actualManager = this.manager;
		Worker newManager = this.workersList.get(newManagerPosition);
		actualManager.setPosition(PositionValue.dependent);
		newManager.setPosition(PositionValue.manager);
		actualManager.setWorkerID(workersList.get(newManagerPosition).getWorkerID());
		newManager.setWorkerID(0);
		this.manager = newManager;
		sortWorkersList();
	}
	
	public void hireWorker(String name, String lastName, String ci, PositionValue position, ScholarDegreeValue scholarDegree)
	{
		Worker hiredWorker = new Worker(name, lastName, ci, generateID(), position, scholarDegree);
		workersList.add(hiredWorker.getWorkerID(), hiredWorker);
	}
	
	public void fireWorker(int ID)
	{
		for(int i = 0; i < workersList.size(); i++){
			Worker analizedWorker = workersList.get(i);
			if(analizedWorker.getWorkerID() == ID){
				workersList.remove(i);
			}
		}
	}
	
	private void sortWorkersList()
	{
		Collections.sort(workersList, new Comparator<Worker>() {
			@Override
			public int compare(Worker wrk1, Worker wrk2) {
				// TODO Auto-generated method stub
				return wrk1.getWorkerID().compareTo(wrk2.getWorkerID());
			}
		});
	}
	
	private Integer generateID()
	{
		int ID = 0;
		if(this.isContinous()){
			ID = workersList.size();
		}
		else{
			ID = findMissingID();
		}
		return ID;
	}
	
	private boolean isContinous()
	{
		boolean continous = true;
		
		for(int i = 0; i < workersList.size(); i++)
		{
			if(i != workersList.get(i).getWorkerID()){
				continous = false;
			}
		}
		return continous;
	}
	
	private int findMissingID(){
		int ID = 0;
		boolean finded = false;
		for(int i = 0; i < workersList.size() && !finded; i++){
			if(i != workersList.get(i).getWorkerID()){
				ID = workersList.get(i - 1).getWorkerID() + 1;
				finded = true;
			}
		}
		return ID;
	}
}
