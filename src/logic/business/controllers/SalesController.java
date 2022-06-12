package logic.business.controllers;

import java.util.ArrayList;

import logic.business.abstractions.Disc;
import logic.business.auxiliars.CDManager;
import logic.business.auxiliars.DVDManager;
import logic.business.auxiliars.SCManager;
import logic.business.auxiliars.SearchManager;
import logic.business.auxiliars.ShoppingCar;
import logic.business.core.Product;
import logic.business.core.Song;
import logic.business.core.Video;

public class SalesController {
	//Te dejo de tarea cambiar la estructura para q existan 2 listas, una de canciones y otra de videos, asi cada Manager no tiene
	//q trabajar con informacion q no le toca
	private ArrayList<Song> songsList;
	private ArrayList<Video> videosList;
	private ArrayList<Integer> sellReports;
	private ShoppingCar shoppingCar;


	public SalesController(ArrayList<Product> database)
	{	
		this.shoppingCar = new ShoppingCar();
		this.songsList = new ArrayList<Song>();
		this.videosList = new ArrayList<Video>();
		this.sellReports = new ArrayList<Integer>();
		arrange(database);

	}

	public void addToShoppingList(Disc item){	
		if(!item.isEmpty()){
			item.setID(sellReports.size()+1);
			shoppingCar.addItem(item);
			sellReports.add(sellReports.size()+1);
		}
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

	public ArrayList<Video> getVideoList(){
		return videosList;
	}
	public ArrayList<Song> getSongsList(){
		return songsList;
	}
	public void sell(){

	}


	//llena las listas de canciones y videos
	public void arrange(ArrayList<Product> database){
		for(int i=0; i<database.size();i++){
			if(database.get(i) instanceof Song){
				songsList.add((Song)database.get(i));
			}else{
				videosList.add((Video)database.get(i));
			}
		}
	}

}

