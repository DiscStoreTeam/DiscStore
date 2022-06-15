package logic.business.abstractions;



import logic.business.core.Product;

public interface IContainerManager {
	public boolean addItem(IProduct item);
	public void removeItem(IProduct item);
	public void removeItem(int index);
	public double calculateCost();
	public void sell();
}
