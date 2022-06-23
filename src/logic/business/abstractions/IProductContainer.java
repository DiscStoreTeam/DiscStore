package logic.business.abstractions;

import java.util.ArrayList;

import logic.business.core.Product;

public interface IProductContainer extends IContainer{
	public boolean isEmpty();
	public ArrayList<Product> getProducts();
	public String getStringContent();
}