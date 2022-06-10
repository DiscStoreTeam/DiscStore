package logic.business.abstractions;

public interface ProductContainer {
	public boolean addItem(IProduct item);
	public void removeItem(IProduct item);
	public void removeItem(int index);
	public double calculateCost();
	public boolean isEmpty();
}