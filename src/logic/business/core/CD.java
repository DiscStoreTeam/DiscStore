package logic.business.core;

import java.util.ArrayList;

import logic.business.abstractions.Disc;
import logic.business.abstractions.IProduct;


public class CD extends Disc{
	private ArrayList<Song> contents;
	private double priceBase =  12.50;

	//Builders
	public CD()
	{
		contents = new ArrayList<Song>();
	}

	//Methods

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
	public boolean isEmpty() {
		boolean empty = false;
		if(contents.isEmpty()){
			empty = true;
		}
		return empty;
	}
	
	public void addSong(Song song){
		contents.add(song);
	}
	public ArrayList<Song> getContents(){
		return this.contents;
	}

	@Override
	public ArrayList<Product> getProducts() {
		// TODO Auto-generated method stub		
		return castSongs();
	}
	public ArrayList<Product> castSongs(){
		ArrayList<Product>a = new ArrayList<Product>();
		for (Song song : contents) {
			a.add(song);
		}
		return a;
	}

	@Override
	public String getStringContent() {
		String text = ""; int num =1;
		for(Song song : contents)
			text += (num++) +" - "+ song.getTitle() +" - "+ song.getInterpreter()+ "\n";
		return text;
	}
	
}
