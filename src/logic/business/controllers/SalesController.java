package logic.business.controllers;

import java.util.ArrayList;


import logic.business.abstractions.Disc;
import logic.business.abstractions.IProduct;
import logic.business.auxiliars.CDManager;
import logic.business.auxiliars.DVDManager;
import logic.business.auxiliars.SCManager;
import logic.business.auxiliars.SellReports;
import logic.business.auxiliars.ShoppingCar;
import logic.business.core.Song;
import logic.business.core.Video;
import logic.business.core.Worker;
import logic.util.Resolution;

public class SalesController {
	//Te dejo de tarea cambiar la estructura para q existan 2 listas, una de canciones y otra de videos, asi cada Manager no tiene
	//q trabajar con informacion q no le toca
	private ArrayList<Song> songsList;
	private ArrayList<Video> videosList;
	private ArrayList<SellReports> sellReports;
	private ArrayList<Disc> history;
	private ShoppingCar shoppingCar;
	private Worker loggedWorker;


	public SalesController(ArrayList<Song> songDatabase, ArrayList<Video> videoDatabase, Worker loggedWorker)
	{	
		this.shoppingCar = new ShoppingCar();
		this.songsList = new ArrayList<Song>(songDatabase);
		this.videosList = new ArrayList<Video>(videoDatabase);
		this.sellReports = new ArrayList<SellReports>();
		this.history = new ArrayList<Disc>();
		this.loggedWorker = loggedWorker;
		
		//String title, String genre, int duration, String interpreter, String collaborators, int fileSize, String author, String album
		
		
		
	}

	public CDManager getCDManager(){
		return new CDManager(this, songsList);
	}
	public DVDManager getDVDManager(){
		return new DVDManager(this, videosList);
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
		getSCManager().sell();
	}
	public int getReportId(){
		return history.size()+1;
	}
	public void addHistory(IProduct item){
		history.add((Disc)item);
	}
	public ArrayList<Disc> getHistory(){
		return history;
	}
	public void addSellReport(SellReports sellReport){
		sellReports.add(sellReport);
	}
	public ArrayList<SellReports> getSellReports(){
		return this.sellReports;
	}
	public Worker getLoggedWorker(){
		return loggedWorker;
	}
	public void updateLoggedWorker(Worker loggedWorker){
		this.loggedWorker = loggedWorker;
	}
}


