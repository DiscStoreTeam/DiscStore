package logic.business;

import java.util.ArrayList;

public class DVD implements Disc{
	private ArrayList<Video> contents;
	
	@Override
	public Video getItem(int item) {
		return contents.get(item);
	}
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
}
