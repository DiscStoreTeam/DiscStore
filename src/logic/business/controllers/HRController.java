package logic.business.controllers;

import java.util.ArrayList;

import logic.business.Worker;
import logic.util.PositionValue;
import logic.util.ScholarDegreeValue;

public class HRController {
	private ArrayList<Worker> workersList;
	private Worker manager;
	
	//Builders
	public HRController(Worker manager)
	{
		this.workersList = new ArrayList<Worker>();
		this.manager = new Worker(manager);
		workersList.add(manager);
	}
	
	public HRController(String name, String lastName, String ci, PositionValue position, ScholarDegreeValue scholarDegree)
	{
		this.workersList = new ArrayList<Worker>();
		this.manager = new Worker(name, lastName, ci, 0, position, scholarDegree);
		workersList.add(manager);
	}
	
	public HRController(ArrayList<Worker> workersList)
	{
		this.workersList = new ArrayList<Worker>(workersList);
		this.manager = new Worker(workersList.get(0));
	}
	
	//Methods
	public void changeManager(int newManagerPosition){
		/* Analizar el tema del cambio de ID al cambiar el admin*/
		manager.setPosition(PositionValue.dependent);
		manager.setWorkerID(workersList.get(newManagerPosition).getWorkerID());
		
		System.out.println(manager.getName() + manager.getWorkerID());
		
		workersList.get(newManagerPosition).setPosition(PositionValue.manager);
		manager = workersList.get(newManagerPosition);
		manager.setWorkerID(0);
		System.out.println(manager.getName() + workersList.get(newManagerPosition).getWorkerID());
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
		System.out.println("Contratar Trabajador(IDs correctos) : " + continous);
		return continous;
	}
	
	private int findMissingID(){
		int ID = 0;
		boolean finded = false;
		for(int i = 0; i < workersList.size() && !finded; i++){
			System.out.println("Analizando : " + workersList.get(i).getName() + " en la posicion : " + i + " de ID : " + workersList.get(i).getWorkerID());
			if(i != workersList.get(i).getWorkerID()){
				//System.out.println(workersList.get(i).getName());
				ID = workersList.get(i - 1).getWorkerID() + 1;
				System.out.println("ID del nuevo trabajador : " + ID);
				finded = true;
			}
		}
		return ID;
	}
	
	public ArrayList<Worker> getworkers(){return workersList;}
	public String getManagerName(){return manager.getName();}
}
