package interfaces.gui.workflow;

import interfaces.gui.database.NewProduct;
import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

public class AddProductHandler implements WindowHandler {
	NewProduct frame;

	@Override
	public Window open(final Store store) {
		store.reload();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new NewProduct(store);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}

}
