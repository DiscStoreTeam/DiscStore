package logic.business.core;

import java.util.ArrayList;

import logic.business.abstractions.Disc;
import logic.business.abstractions.IProduct;


public class DVD extends Disc {
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
	/*@Override
	public ArrayList<IProduct> search(String critery) {
		ArrayList<IProduct> searchList = new ArrayList<IProduct>();
		for(int i = 0; i<contents.size();i++){
			if(contents.get(i).getTitle().equalsIgnoreCase(critery)){
				searchList.add((IProduct) contents.get(i));			
			}
		}	
		return searchList;
	}*/
	/*@Override
	/*public Product getItem(int index) {
		return contents.get(index);
	}*/

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(contents.isEmpty()){
			empty = true;
		}
		return empty;
	}

	@Override
	public ArrayList<Product> getProducts() {
		// TODO Auto-generated method stub		
		return castVideos();
	}
	public ArrayList<Product> castVideos(){
		ArrayList<Product>a = new ArrayList<Product>();
		for (Video video : contents) {
			a.add(video);
		}
		return a;
	}

	@Override
	public String getStringContent() {
		String text = ""; int num =1;
		for(Video video : contents)
			text += (num++) +" - "+ video.getTitle() +" - "+ video.getInterpreter()+ "\n";
		return text;
	}
	
}

