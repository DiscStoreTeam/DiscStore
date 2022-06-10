package logic.business.controllers;

import java.util.ArrayList;

import logic.business.core.Worker;

public class AccessController {
	private ArrayList<Worker> workersList;
	private Worker loggedWorker;
	
	//Builders
	public AccessController(ArrayList<Worker> workersList){
		this.workersList = workersList;
		this.loggedWorker = null;
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
			default:
				break;
			}
		}
		return workerID;
	}
	
	public boolean fistLogin()
	{
		return loggedWorker.firstLogin();
	}
	
	public void updateCredentials(String username, String password)
	{
		loggedWorker.updateCredentials(username, password);
	}
	
	public boolean compareUsername(String username){
		boolean exist = false;
		for(int i = 0; i < workersList.size() && !exist; i++){
			if(workersList.get(i).getCredentials().getUsername().equalsIgnoreCase(username)){
				exist = true;
			}
		}
		return exist;
	}
}
