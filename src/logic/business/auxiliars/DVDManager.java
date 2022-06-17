package logic.business.auxiliars;

import java.util.ArrayList;

import logic.business.abstractions.IContainerManager;
import logic.business.abstractions.IProduct;
import logic.business.controllers.SalesController;
import logic.business.core.DVD;
import logic.business.core.Song;
import logic.business.core.Video;

public class DVDManager implements IContainerManager {
	private SalesController controller;
	private SearchManager<Video> searcher;
	private DVD dvd;
	private ArrayList<Video> database;

	public DVDManager(SalesController controller, ArrayList<Video> database)
	{
		this.controller = controller;
		dvd = new DVD();
		searcher = new SearchManager<Video>();
		this.database = database;
	}

	public DVD getDVD(){
		return dvd;
	}
	@Override
	public boolean addItem(IProduct item) {
		// TODO Auto-generated method stub	
		return dvd.addItem(item);
	}
	@Override
	public void removeItem(IProduct item) {
		dvd.removeItem(item);
	}
	@Override
	public void removeItem(int index) {
		dvd.removeItem(index);
	}
	@Override
	public double calculateCost() {
		return dvd.calculateCost();
	}
	public ArrayList<Video> search(String critery) {
		return searcher.search(critery, database);
	}
	@Override
	public void sell() {
		//Lo mismo de cd
	}
	public ArrayList<Video>getDatabase(){
		return this.database;
	}

}
