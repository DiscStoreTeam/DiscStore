package logic.business.abstractions;

import java.util.ArrayList;

import logic.business.core.Product;

public interface ProductContainer {
	public boolean addItem(IProduct item);
	public void removeItem(IProduct item);
	public void removeItem(int index);
	public double calculateCost();
	public boolean isEmpty();
	public ArrayList<Product> getProducts();
	public String getStringContent();
}