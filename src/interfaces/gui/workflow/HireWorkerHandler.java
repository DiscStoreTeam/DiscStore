package interfaces.gui.workflow;

import interfaces.gui.workers.HireWorker;

import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

public class HireWorkerHandler implements WindowHandler {
	HireWorker frame;

	@Override
	public Window open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new HireWorker(store);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}
}
