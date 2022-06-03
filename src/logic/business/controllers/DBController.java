package logic.business.controllers;

import java.util.ArrayList;

import logic.business.Product;
import logic.util.Resolution;

public class DBController {
	private ArrayList<Product> database;
	private ArrayList<Resolution> registeredResolutions;
	
	//Builders
	public DBController(ArrayList<Product> database)
	{
		this.database = database;
	}
	public DBController()
	{
		this.database = new ArrayList<Product>();
	}
	
	//Methods
	public ArrayList<String> getRegisteredResolutions()
	{
		ArrayList<String> resolutions = new ArrayList<String>();
		for(Resolution resolution : registeredResolutions)
		{
			resolutions.add(resolution.toString());
		}
		return resolutions;
	}
}
