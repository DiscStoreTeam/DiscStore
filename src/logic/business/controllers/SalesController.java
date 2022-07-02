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

public class SalesController {
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
	public void reload(ArrayList<Song> songDatabase, ArrayList<Video> videoDatabase, Worker loggedWorker){
		this.songsList = songDatabase;
		this.videosList = videoDatabase;
		this.loggedWorker = loggedWorker;
	}
}


