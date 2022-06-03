package logic.business;

import java.util.ArrayList;

public class DVD extends Disc implements ProductContainer{
	private ArrayList<Video> contents;
	
	//Methods
	@Override
	public void addItem() {
		
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
