package logic.business;

import java.util.ArrayList;

import logic.business.abstractions.IContainerManager;
import logic.business.abstractions.IProduct;
import logic.business.controllers.SalesController;

public class SCManager implements IContainerManager {
	//Esto del manager es una solucion temporal, aki vamos a aplicar otro patron
	//Anotado Patron Proxy
	//los Manager tiene acceso al controller para poder interactuar con el
	private SalesController controller; 
	private ShoppingCar shoppingCar;
	
	//Builders
	public SCManager(SalesController controller, ShoppingCar shoppingCar)
	{
		this.controller = controller;
		this.shoppingCar = shoppingCar;
	}

	//Methods
	@Override
	public boolean addItem(IProduct item) {
		return shoppingCar.addItem(item);
	}
	@Override
	public void removeItem(IProduct item) {
		shoppingCar.removeItem(item);
	}
	@Override
	public void removeItem(int index) {
		shoppingCar.removeItem(index);
	}
	@Override
	public double calculateCost() {
		return shoppingCar.calculateCost();
	}
	@Override
	public ArrayList<IProduct> search(String critery) {
		return null;
	}
	@Override
	public void sell() {
		
	}
}
