package logic.business;

import logic.util.Credential;
import logic.util.Position;
import logic.util.ScholarDegree;

public class Worker {
	private String name;
	private String lastName;
	private String ci;
	private Integer workerID;
	private double basicSalary;
	private Position position;
	private ScholarDegree scholarDegree;
	private Credential credentials;
	
	//Builders
	public Worker(String name, String lastName, String ci, int workerID, int position, int scholarDegree) {
		this.name = new String(name);
		this.lastName = new String(lastName);
		this.ci = new String(ci);
		this.workerID = new Integer(workerID);
		this.position = new Position(position);
		this.scholarDegree = new ScholarDegree(scholarDegree);
		this.credentials = new Credential(name, ci);
		switch (position) {
		case 0:
			this.basicSalary = 5000;
			break;
		case 1:
			this.basicSalary = 3500;
			break;
		case 2:
			this.basicSalary = 3000;
			break;
		}
	}
	
	//Methods
	public boolean isMe(String username, String password)
	{
		boolean valid = false;
		
		if(credentials.getUsername().equalsIgnoreCase(username)){
			if(credentials.getPassword().equals(password)){
				valid = true;
			}
		}
		
		return valid;
	}
	
	public void changeCredentials(String username, String password)
	{
		credentials.updateCredentials(username, password);
	}
	
	public boolean firstLogin()
	{
		return credentials.getFirstLogin();
	}
	
	//Validations
	public static boolean validateCI(String ci)
	{
		boolean valid = true;
		
		if(ci.length() == 11){
			for(int i = 0; i < ci.length() && valid; i++){
				if(!Character.isDigit(ci.charAt(i))){
					valid = false;
				}
			}
		} 
		else {
			valid = false;
		}
		
		return valid;
	}
	public static boolean validateName(String name)
	{
		boolean valid = true;
		
		for(int i = 0; i < name.length(); i++){
			if(!Character.isLetter(name.charAt(i))){
				valid = false;
			}
		}
		
		return valid;
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
	//position
	public Position getPosition() {return position;}
	//scholarDegree
	public ScholarDegree getScholarDegree() {return scholarDegree;}
	//credentials
	public Credential getCredentials() {return credentials;}
}
