package interfaces.gui.workflow;

import interfaces.gui.access.Login;
import interfaces.gui.sales.Sales;

import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

@SuppressWarnings("unused")
public class SalesHandler implements WindowHandler{
	Sales frame;
	
	public SalesHandler(){
		
	}

	@Override
	public Window open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Sales(store);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}
}
