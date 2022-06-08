package logic.business;

import java.util.ArrayList;

import logic.business.abstractions.IDisc;
import logic.business.abstractions.IProduct;
import logic.business.abstractions.ProductContainer;

public class ShoppingCar implements ProductContainer {
	private ArrayList<IDisc> discs;
	private double totalCost = 0;
	private String a;
	//Builders
	public ShoppingCar()
	{
		discs = new ArrayList<IDisc>();
		totalCost = calculateCost();
	}
	
	//Methods
	@Override
	public boolean addItem(IProduct item) {
		discs.add((IDisc) item);
		return true;
	}
	@Override
	public void removeItem(IProduct item) {
		for(int i = 0; i<discs.size();i++){
			if(discs.get(i).equals((IDisc)item)){
				discs.remove(i);
			}
		}
	}
	@Override
	public void removeItem(int index) {
		discs.remove(index);
	}
	@Override
	public double calculateCost() {
		for(int i = 0; i<discs.size(); i++){
			totalCost += discs.get(i).calculateCost();
		}
		return totalCost;
	}
	
	public double getTotalCost(){
		return totalCost;
	}
	/*@Override
	public ArrayList<IProduct> search(String critery) {
		return null;
	}*/
}
