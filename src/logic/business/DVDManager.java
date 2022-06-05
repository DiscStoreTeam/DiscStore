package logic.business;

import java.util.ArrayList;

import logic.business.abstractions.IContainerManager;
import logic.business.abstractions.IProduct;
import logic.business.controllers.SalesController;

public class DVDManager implements IContainerManager {
	private SalesController controller;
	private DVD dvd;
	
	public DVDManager(SalesController controller)
	{
		this.controller = controller;
		dvd = new DVD();
	}

	@Override
	public boolean addItem(IProduct item) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void removeItem(IProduct item) {

	}
	@Override
	public void removeItem(int index) {

	}
	@Override
	public double calculateCost() {
		return 0;
	}
	@Override
	public ArrayList<IProduct> search(String critery) {
		return null;
	}
	@Override
	public void sell() {
		//Lo mismo de cd
	}
}
