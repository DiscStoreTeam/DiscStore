package interfaces.gui.workflow;

import interfaces.gui.sales.ShoppingCarGUI;

import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

public class ShoppingcarHandler implements WindowHandler {
	ShoppingCarGUI frame;
	

	@Override
	public Window open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ShoppingCarGUI(store);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}
}




