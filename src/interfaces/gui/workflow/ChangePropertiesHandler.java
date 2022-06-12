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
	public void open(final Store store, final Window father) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ChangeProperties(store, father);
					frame.setVisible(true);
					father.setEnabled(false);
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
