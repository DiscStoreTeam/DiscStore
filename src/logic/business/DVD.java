package logic.business;

import java.util.ArrayList;

import logic.business.abstractions.IDisc;
import logic.business.abstractions.IProduct;
import logic.business.abstractions.ProductContainer;

public class DVD extends IDisc {
	private ArrayList<Video> contents;
	private double priceBase = 15.50;
	
	//Builders
	public DVD()
	{
		contents = new ArrayList<Video>();
	}
	
	//Methods	
	@Override
	public boolean addItem(IProduct item) {
		contents.add((Video) item);		
		return true;
	}
	@Override
	public void removeItem(IProduct item) {
		for(int i = 0; i<contents.size();i++){
			if(contents.get(i).equals((Video)item)){
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
		return priceBase + contents.size()*4.50;
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
