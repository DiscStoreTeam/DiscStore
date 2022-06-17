package logic.business.auxiliars;

import java.util.ArrayList;

import logic.business.abstractions.Disc;
import logic.business.abstractions.IContainerManager;
import logic.business.abstractions.IProduct;
import logic.business.controllers.SalesController;
import logic.business.core.Worker;

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

	public ShoppingCar getShoppingcar(){
		return this.shoppingCar;
	}
	public double getTotalCost(){
		return shoppingCar.getTotalCost();
	}
	public ArrayList<Disc> getDiscs(){
		return shoppingCar.getDiscs();
	}
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
	public void sell() {
		ArrayList<Disc> auxiliar = shoppingCar.getDiscs();
		for(Disc disc : auxiliar){
			controller.addSellReport(generateSellReport(controller.getSellReports().size()+1, disc.getStringContent(), disc.calculateCost(), controller.getLoggedWorker(), disc));
		}
		shoppingCar.cleanShoppingCar();
	}
	public SellReports generateSellReport(int id, String content, double cost, Worker worker, Disc disc){
		SellReports a = new SellReports(id, content, cost, worker, disc);
		return a;
	}


	
	
}





