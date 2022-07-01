package interfaces.gui.workflow;

import interfaces.gui.access.Login;

import java.awt.EventQueue;
import java.awt.Window;

import logic.business.core.Store;

public class LoginHandler implements WindowHandler {
	Login frame;
	
	public LoginHandler(){
		
	}
	
	@Override
	public Window open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login(store.getAccessController());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return frame;
	}
}
