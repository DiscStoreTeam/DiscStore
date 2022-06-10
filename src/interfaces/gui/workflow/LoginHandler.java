package interfaces.gui.workflow;

import interfaces.gui.access.Login;

import java.awt.EventQueue;

import logic.business.core.Store;

public class LoginHandler implements WindowHandler {
	
	public LoginHandler(){
		
	}
	
	@Override
	public void open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(store.getAccessController());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
