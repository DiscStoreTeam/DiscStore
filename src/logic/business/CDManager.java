package logic.business;

import java.util.ArrayList;

import logic.business.abstractions.IContainerManager;
import logic.business.abstractions.IProduct;
import logic.business.controllers.SalesController;

public class CDManager implements IContainerManager {
	private SalesController controller;
	private CD cd;

	public CDManager(SalesController controller)
	{
		this.controller = controller;
		cd = new CD();
	}

	@Override
	public boolean addItem(IProduct item) {
		// TODO Auto-generated method stub	
		return cd.addItem(item);
	}
	@Override
	public void removeItem(IProduct item) {
		cd.removeItem(item);
	}
	@Override
	public void removeItem(int index) {
		cd.removeItem(index);		
	}
	@Override
	public double calculateCost() {
		return cd.calculateCost();
	}
	/*@Override
	public ArrayList<IProduct> search(String critery) {
		return null;
	}*/
	@Override
	public void sell() {
		//Cuando se haga el sell significa q el cd pasa al carrito, por tanto le pasas la referencia al array list del 
		//carrito y el cd de aki le haces un new por si el usuario va a buscar otra cosa
	}
}
