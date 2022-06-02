package logic.business;

public interface Disc {	
	public Product getItem(int item);
	public void addItem();
	public void removeItem();
	public double calculateCost();
}
