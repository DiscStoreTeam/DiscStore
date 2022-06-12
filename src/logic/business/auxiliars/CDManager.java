package logic.business.auxiliars;

import java.util.ArrayList;

import logic.business.abstractions.IContainerManager;
import logic.business.abstractions.IProduct;
import logic.business.controllers.SalesController;
import logic.business.core.CD;
import logic.business.core.Song;

public class CDManager implements IContainerManager {
	private SalesController controller;
	private SearchManager<Song> searcher; 
	private CD cd;
	private ArrayList<Song> database;

	public CDManager(SalesController controller, ArrayList<Song> database)
	{
		this.controller = controller;
		cd = new CD();
		searcher = new SearchManager<Song>();
		this.database = database;
	}

	public CD getCD(){
		return cd;
	}
	@Override
	public boolean addItem(IProduct item) {
		// TODO Auto-generated method stub	
		return cd.addItem(item);
	}
	@Override
	public void removeItem(IProduct item) {
		cd.removeItem(item);
	}
	@Override
	public void removeItem(int index) {
		cd.removeItem(index);		
	}
	@Override
	public double calculateCost() {
		return cd.calculateCost();
	}
	
	public ArrayList<Song> search(String critery) {
		return searcher.search(critery, database);
	}
	@Override
	public void sell() {
		//Cuando se haga el sell significa q el cd pasa al carrito, por tanto le pasas la referencia al array list del 
		//carrito y el cd de aki le haces un new por si el usuario va a buscar otra cosa
	}
	public ArrayList<Song>getDatabase(){
		return this.database;
	}
}
