package logic.business.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import logic.business.Worker;
import logic.util.Position;
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
	}
	
	//Methods
	public void changeManager(int worker ,PositionValue newPosition){
		manager.setPosition(newPosition);
		workersList.get(worker).setPosition(PositionValue.manager);
		manager = workersList.get(worker);
		updatePositions();
	}
	
	public boolean hireWorker(String name, String lastName, String ci, PositionValue position, ScholarDegreeValue scholarDegree)
	{
		boolean valid = true;
		if((numberOfPosition(position)) <= 9){
			Worker hiredWorker = new Worker(name, lastName, ci, generateID(position), position, scholarDegree);
			workersList.add(hiredWorker);
			sortWorkersList();
		}
		else{
			valid = false;
		}
		return valid;
	}
	
	private void sortWorkersList()
	{
		Collections.sort(workersList, new Comparator<Worker>() {
			@Override
			public int compare(Worker wrk1, Worker wrk2) {
				// TODO Auto-generated method stub
				return new Integer((wrk1.getWorkerID().compareTo(wrk2.getWorkerID())));
			}
		});
	}
	
	private String generateID(PositionValue position)
	{
		String ID = Position.toInt(position).toString();
		Integer count = 0;
		count = numberOfPosition(position);
		ID = ID + count.toString();
		return ID;
	}
	
	private int numberOfPosition(PositionValue positionValue)
	{
		int amount = 0;
		char position = Position.toInt(positionValue).toString().charAt(0);
		
		for(int i = 0; i < workersList.size(); i++){
			if(workersList.get(i).getWorkerID().charAt(0) == position){
				amount++;
			}
		}
		return amount;
	}
	
	public void updatePositions()
	{
		//Manager change
		for(int i = 0; i < workersList.size(); i++){
			Worker analizedWorker = workersList.get(i);
			char positionID = analizedWorker.getWorkerID().charAt(0);
			char position = Position.toInt(analizedWorker.getPosition()).toString().charAt(0);
			if(position != positionID){
				char auxiliar;
				if(position == '0'){
					auxiliar = '0';
				}
				else{
					auxiliar = analizedWorker.getWorkerID().charAt(1);
				}
				char auxiliarArray[] = {position, auxiliar};
				analizedWorker.setWorkerID(new String(auxiliarArray));
			}
		}
	}
}
