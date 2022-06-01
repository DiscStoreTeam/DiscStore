package logic.business;

import java.util.ArrayList;

public class CD implements Disc{
	private ArrayList<Song> contents;
	
	//Builders
	public CD()
	{
		contents = new ArrayList<Song>();
	}
	
	//Methods
	@Override
	public Song getItem(int item) {
		return contents.get(item);
	}
	
	@Override
	public void addItem(){
		
	}
	
	@Override
	public void removeItem() {
		
	}
	@Override
	public double calculateCost() {
		return 0;
	}
}
