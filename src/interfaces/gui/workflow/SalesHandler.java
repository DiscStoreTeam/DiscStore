package interfaces.gui.workflow;

import interfaces.gui.access.Login;
import interfaces.gui.access.Sales;

import java.awt.EventQueue;

import logic.business.core.Store;

public class SalesHandler implements WindowHandler{
	
	public SalesHandler(){
		
	}

	@Override
	public void open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales frame = new Sales(store.getSalesController());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
