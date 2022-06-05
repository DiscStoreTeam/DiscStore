package logic.business.controllers;

import java.util.ArrayList;

import logic.business.CDManager;
import logic.business.DVDManager;
import logic.business.Product;
import logic.business.SCManager;
import logic.business.ShoppingCar;
import logic.business.Song;
import logic.business.abstractions.IDisc;

public class SalesController {
	//Te dejo de tarea cambiar la estructura para q existan 2 listas, una de canciones y otra de videos, asi cada Manager no tiene
	//q trabajar con informacion q no le toca
	private ArrayList<Product> database;
	private ArrayList<Product> songsList;
	private ArrayList<Product> videosList;	
	private ShoppingCar shoppingCar;
	
	public SalesController(ArrayList<Product> database)
	{
		this.database = database;		
		this.shoppingCar = new ShoppingCar();
		this.songsList = new ArrayList<Product>();
		this.videosList = new ArrayList<Product>();
		arrange();
	}
	
	public void addToShoppingList(IDisc item){
		
	}
	public CDManager getCDManager(){
		return new CDManager(this);
	}
	public DVDManager getDVDManager(){
		return new DVDManager(this);
	}
	public SCManager getSCManager(){
		return new SCManager(this, shoppingCar);
	}
	public void sell(){
		
	}
	
	
	//llena las listas de canciones y videos
	public void arrange(){
		for(int i=0; i<database.size();i++){
			if(database.get(i) instanceof Song){
				songsList.add(database.get(i));
			}else{
				videosList.add(database.get(i));
			}
		}
	}
	
}
 
