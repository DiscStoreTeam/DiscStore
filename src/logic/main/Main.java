package logic.main;

import java.util.ArrayList;

import logic.business.Product;
import logic.business.controllers.DBController;

public final class Main {

	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		DBController controller = new DBController(products);
	}
}
