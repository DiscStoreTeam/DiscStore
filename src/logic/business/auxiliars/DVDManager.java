package logic.business.auxiliars;

import java.util.ArrayList;

import logic.business.abstractions.IContainerManager;
import logic.business.abstractions.IProduct;
import logic.business.controllers.SalesController;
import logic.business.core.DVD;

public class DVDManager implements IContainerManager {
	private SalesController controller;
	private DVD dvd;
	
	public DVDManager(SalesController controller)
	{
		this.controller = controller;
		dvd = new DVD();
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
	/*@Override
	public ArrayList<IProduct> search(String critery) {
		return null;
	}*/
	@Override
	public void sell() {
		//Lo mismo de cd
	}
}
