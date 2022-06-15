package logic.business.auxiliars;

import java.util.ArrayList;

import logic.business.abstractions.Disc;
import logic.business.abstractions.IProduct;
import logic.business.abstractions.ProductContainer;
import logic.business.core.Product;

public class ShoppingCar implements ProductContainer {
	private ArrayList<Disc> discs;
	private double totalCost = 0;

	//Builders
	public ShoppingCar()
	{
		discs = new ArrayList<Disc>();
		totalCost = calculateCost();
	}

	//Methods
	@Override
	public boolean addItem(IProduct item) {
			discs.add((Disc) item);
			
		return true;
	}
	@Override
	public void removeItem(IProduct item) {
		for(int i = 0; i<discs.size();i++){
			if(discs.get(i).equals((Disc)item)){
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
		totalCost = 0;
		for(int i = 0; i<discs.size(); i++){
			totalCost += discs.get(i).calculateCost();
		}
		return totalCost;
	}

	public double getTotalCost(){
		return totalCost;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(discs.isEmpty()){
			empty = true;
		}
		return empty;
	}
	public ArrayList<Disc> getDiscs(){
		return this.discs;
	}

	@Override
	public ArrayList<Product> getProducts() {
		ArrayList<Product> a = new ArrayList<Product>();
		for (Disc disc : discs) {
			a.addAll(disc.getProducts());
		}
		return a;
	}
}
