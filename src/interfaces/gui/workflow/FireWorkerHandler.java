package interfaces.gui.workflow;

import interfaces.gui.workers.FireWorker;
import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

public class FireWorkerHandler implements WindowHandler {
	FireWorker frame;

	@Override
	public Window open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FireWorker(store);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}
}
