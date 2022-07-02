package interfaces.gui.workflow;

import interfaces.gui.database.DeleteProduct;
import interfaces.gui.database.NewProduct;

import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

public class DeleteProductHandler implements WindowHandler{
	DeleteProduct frame;

	@Override
	public Window open(final Store store) {
		store.reload();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteProduct(store);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}
}
