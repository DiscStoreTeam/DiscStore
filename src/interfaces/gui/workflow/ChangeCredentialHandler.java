package interfaces.gui.workflow;

import interfaces.gui.access.ChangeCredentials;

import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

public class ChangeCredentialHandler implements WindowHandler {
	ChangeCredentials frame;
	
	public ChangeCredentialHandler(){
		
	}
	
	@Override
	public Window open(final Store store, Window father) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ChangeCredentials(store.getAccessController());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}
}
