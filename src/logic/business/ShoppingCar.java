package logic.business;

import java.util.ArrayList;

import logic.business.abstractions.IDisc;
import logic.business.abstractions.IProduct;
import logic.business.abstractions.ProductContainer;

public class ShoppingCar implements ProductContainer {
	private ArrayList<IDisc> discs;
	
	//Builders
	public ShoppingCar()
	{
		discs = new ArrayList<IDisc>();
	}
	
	//Methods
	@Override
	public boolean addItem(IProduct item) {
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
}
