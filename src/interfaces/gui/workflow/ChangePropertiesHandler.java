package interfaces.gui.workflow;

import interfaces.gui.main.ChangeProperties;

import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

public class ChangePropertiesHandler implements WindowHandler {
	ChangeProperties frame;
	
public ChangePropertiesHandler(){
		
	}
	
	@Override
	public Window open(final Store store, final Window father) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ChangeProperties(store, father);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}
}
