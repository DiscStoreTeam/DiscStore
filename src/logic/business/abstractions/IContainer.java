package logic.business.abstractions;

public interface IContainer {
	public boolean addItem(IProduct item);
	public void removeItem(IProduct item);
	public void removeItem(int index);
	public double calculateCost();
}
