package interfaces.gui.workflow;

import interfaces.gui.access.ChangeCredentials;

import java.awt.EventQueue;

import logic.business.controllers.AccessController;
import logic.business.core.Store;

public class ChangeCredentialHandler implements WindowHandler {
	AccessController controller;
	
	public ChangeCredentialHandler(){
		
	}
	
	@Override
	public void open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeCredentials frame = new ChangeCredentials(store.getAccessController());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
