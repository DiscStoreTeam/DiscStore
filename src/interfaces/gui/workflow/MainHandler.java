package interfaces.gui.workflow;

import interfaces.gui.main.MainWindow;

import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

public class MainHandler implements WindowHandler {
	MainWindow frame;

	public MainHandler() {
		
	}
	
	@Override
	public Window open(final Store store, Window father) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}
}
