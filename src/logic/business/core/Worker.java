package logic.business.core;

import logic.util.Credential;
import logic.util.Position;
import logic.util.PositionValue;
import logic.util.ScholarDegree;
import logic.util.ScholarDegreeValue;

public class Worker {
	private String name;
	private String lastName;
	private String ci;
	private Integer workerID;
	private double basicSalary;
	private ScholarDegree scholarDegree;
	private Credential credentials;
	private Position position;
	
	//Builders
	public Worker(String name, String lastName, String ci, Integer workerID, PositionValue position, ScholarDegreeValue scholarDegree) {
		this.name = new String(name);
		this.lastName = new String(lastName);
		this.ci = new String(ci);
		this.workerID = new Integer(workerID);
		this.position = new Position(position);
		this.scholarDegree = new ScholarDegree(scholarDegree);
		this.credentials = new Credential(name, ci);
		switch (position) {
		case manager:
			this.basicSalary = 5000;
			break;
		case dependent:
			this.basicSalary = 3500;
			break;
		}
	}
	public Worker(Worker auxiliar){
		this.name = new String(auxiliar.getName());
		this.lastName = new String(auxiliar.getLastName());
		this.ci = new String(auxiliar.getCi());
		this.workerID = new Integer(auxiliar.getWorkerID());
		this.position = new Position(auxiliar.getPosition());
		this.scholarDegree = new ScholarDegree(auxiliar.getScholarDegree());
		this.credentials = new Credential(auxiliar.getCredentials());
		switch (auxiliar.getPosition()) {
		case manager:
			this.basicSalary = 5000;
			break;
		case dependent:
			this.basicSalary = 3500;
			break;
		}
	}
	public Worker(){
		
	}

	//Methods
	public void setNull(){
		this.name = null;
		this.lastName = null;
		this.ci = null;
		this.workerID = null;
		this.position = null;
		this.scholarDegree = null;
		this.credentials = null;
	}
	
	public boolean isNull(){return name == null;}
	
	public int isMe(String username, String password)
	{
		int valid = 0;
		if(credentials.getUsername().equalsIgnoreCase(username)){
			if(credentials.getPassword().equals(password)){
				valid = 2;
			}
			else{
				valid = 1;
			}
		}
		
		return valid;
	}
	
	public void updateCredentials(String username, String password)
	{
		credentials.updateCredentials(username, password);
	}
	
	public boolean firstLogin()
	{
		return credentials.getFirstLogin();
	}

	//Getters & Setters
	//basicSalary
	public double getBasicSalary() {return basicSalary;}
	public void setBasicSalary(double basicSalary) {this.basicSalary = basicSalary;}
	//name
	public String getName() {return name;}
	//lastName
	public String getLastName() {return lastName;}
	//CI
	public String getCi() {return ci;}
	//ID
	public Integer getWorkerID() {return workerID;}
	public void setWorkerID(Integer workerID){this.workerID = new Integer(workerID);}
	//position
	public String positionString(){return position.toString();}
	public PositionValue getPosition() {return position.getValue();}
	public void setPosition(PositionValue value){position.setValue(value);}
	//scholarDegree
	public String degreeString(){return scholarDegree.toString();}
	public ScholarDegreeValue getScholarDegree() {return scholarDegree.getValue();}
	public void setScholarDegree(ScholarDegreeValue value){scholarDegree.setValue(value);}
	//credentials
	public Credential getCredentials() {return credentials;}
}
