package interfaces.gui.workflow;

import interfaces.gui.main.ChangeManager;
import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

public class ChangeManagerHandler implements WindowHandler {
	ChangeManager frame;

	@Override
	public Window open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ChangeManager(store);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}

}
