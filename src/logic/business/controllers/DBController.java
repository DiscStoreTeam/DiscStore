package logic.business.controllers;

import java.util.ArrayList;

import logic.business.Product;
import logic.business.Song;
import logic.business.Video;
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
	
	public boolean addProduct(Product product)
	{
		boolean exist = false;
		
		for(int i = 0; i < database.size() && !exist; i++){
			if(database.get(i).equals(product)){
				exist = true;
			}
		}
		if(!exist){
			if(product instanceof Song){
				addSong((Song)product);
			}
			else{
				addVideo((Video)product);
			}
		}
		
		return exist;
	}
	
	public void addSong(Song newSong)
	{
		database.add(new Song(newSong));
	}
	
	public void addVideo(Video newVideo)
	{
		
	}
	
	public void removeProduct()
	{
		
	}
}
