package logic.business;

import java.util.ArrayList;

import logic.business.abstractions.IDisc;
import logic.business.abstractions.IProduct;
import logic.business.abstractions.ProductContainer;

public class CD extends IDisc implements IProduct, ProductContainer{
	private ArrayList<Song> contents;
	private double priceBase =  12.50;

	//Builders
	public CD()
	{
		contents = new ArrayList<Song>();
	}

	//Methods
	@Override
	public boolean addItem(IProduct item) {
		contents.add((Song) item);		
		return true;
	}
	@Override
	public void removeItem(IProduct item) {
		for(int i = 0; i<contents.size();i++){
			if(contents.get(i).equals((Song)item)){
				contents.remove(i);
			}
		}
	}
	@Override
	public void removeItem(int index) {
		contents.remove(index);
	}
	@Override
	public double calculateCost() {
		return priceBase + contents.size()*2.50;
	}
	@Override
	public ArrayList<IProduct> search(String critery) {
		ArrayList<IProduct> searchList = new ArrayList<IProduct>();
		for(int i = 0; i<contents.size();i++){
			if(contents.get(i).getTitle().equalsIgnoreCase(critery)){
				searchList.add((IProduct) contents.get(i));			
			}
		}	
		return searchList;
	}
	@Override
	public Product getItem(int index) {
		return contents.get(index);
	}
}
