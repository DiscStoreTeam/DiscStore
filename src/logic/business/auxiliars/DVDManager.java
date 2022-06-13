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
	private DVD dvd;
	private SearchManager<Video> searcher;
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

	public SearchManager<Video> getSearch(){
		return this.searcher;
	}


	@Override
	public void removeItem(int index) {
		dvd.removeItem(index);
	}
	@Override
	public double calculateCost() {
		return dvd.calculateCost();
	}
	/*@Override
	public ArrayList<IProduct> search(String critery) {
		return null;
	}*/
	@Override
	public void sell() {
		//Lo mismo de cd
	}
	public ArrayList<Video>getDatabase(){
		return this.database;
	}

	@Override
	public boolean addItem(IProduct item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeItem(IProduct item) {
		// TODO Auto-generated method stub
		
	}
}
