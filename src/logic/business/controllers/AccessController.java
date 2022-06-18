package logic.business.controllers;

import java.util.ArrayList;

import logic.business.core.Store;
import logic.business.core.Worker;
import logic.util.PositionValue;

public class AccessController {
	private ArrayList<Worker> workersList;
	private Worker loggedWorker;
	private Store store;
	
	//Builders
	public AccessController(ArrayList<Worker> workersList, Store store){
		this.workersList = workersList;
		this.loggedWorker = null;
		this.store = store;
	}
	
	//Methods
	public int login(String username, String password)
	{
		int workerID = -2;
		for(int i = 0; i < workersList.size() && loggedWorker == null; i++)
		{
			Worker analizedWorker = workersList.get(i);
			int auxiliar = analizedWorker.isMe(username, password);
			switch (auxiliar) {
			case 1:
				workerID = -1;
				break;
			case 2:
				workerID = analizedWorker.getWorkerID();
				loggedWorker = analizedWorker;
				store.updateLoggedWorker(loggedWorker);
			default:
				break;
			}
		}
		return workerID;
	}
	
	public boolean fistLogin()
	{
		return (loggedWorker.getName().equals("admin")) ? (false) : (loggedWorker.firstLogin());
	}
	
	public void updateCredentials(String username, String password)
	{
		loggedWorker.updateCredentials(username, password);
	}
	
	public boolean compareUsername(String username){
		boolean exist = false;
		for(int i = 0; i < workersList.size() && !exist; i++){
			if(workersList.get(i).getCredentials().getUsername().equalsIgnoreCase(username)){
				if(!loggedWorker.getCredentials().getUsername().equalsIgnoreCase(username)){
					exist = true;
				}
			}
		}
		return exist;
	}
	
	public boolean isManager(){return loggedWorker.getPosition() == PositionValue.manager;}
	
	public void logout(){loggedWorker = null;}
	public Worker getLoggedWorker(){return loggedWorker;}
	
}
