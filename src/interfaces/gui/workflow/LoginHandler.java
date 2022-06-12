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
	public void open(final Store store, Window father) {
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
	}
	
	@Override
	public Window getWindow() {
		return frame;
	}
}
