package logic.business.controllers;

import java.util.ArrayList;

import logic.business.Worker;

public class AccessController {
	private ArrayList<Worker> workersList;
	private Worker loggedWorker;
	
	//Builders
	public AccessController(ArrayList<Worker> workersList){
		this.workersList = workersList;
		this.loggedWorker = null;
	}
	
	//Methods
	public Worker login(String username, String password)
	{
		for(int i = 0; i < workersList.size() && loggedWorker == null; i++)
		{
			Worker analizedWorker = workersList.get(i);
			if(analizedWorker.isMe(username, password))
			{
				loggedWorker = analizedWorker;
			}
		}
		
		return loggedWorker;
	}
	
	public boolean fistLogin()
	{
		return loggedWorker.firstLogin();
	}
	
	public void updateCredentials(String username, String password)
	{
		loggedWorker.changeCredentials(username, password);
	}
}
