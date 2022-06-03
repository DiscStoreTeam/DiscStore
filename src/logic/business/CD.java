package logic.business;

import java.util.ArrayList;

public class CD extends Disc implements ProductContainer{
	private ArrayList<Song> contents;
	
	//Builders
	public CD()
	{
		contents = new ArrayList<Song>();
	}
	
	//Methods	
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

	@Override
	public Product getItem(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
