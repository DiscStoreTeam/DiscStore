package interfaces.gui.workflow;

import interfaces.gui.Sales.Sales;
import interfaces.gui.access.Login;

import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

@SuppressWarnings("unused")
public class SalesHandler implements WindowHandler{
	Sales frame;
	
	public SalesHandler(){
		
	}

	@Override
	public void open(final Store store, Window father) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Sales(store.getSalesController());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	@Override
	public Window getWindow() {
		return frame;
	}
}
