package interfaces.gui.workflow;

import interfaces.gui.main.MainWindow;

import java.awt.EventQueue;

import logic.business.core.Store;

public class MainHandler implements WindowHandler {

	public MainHandler() {
		
	}
	
	@Override
	public void open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
