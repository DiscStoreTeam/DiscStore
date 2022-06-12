package interfaces.gui.workflow;

import java.awt.Window;

import logic.business.core.Store;

public interface WindowHandler {
	public void open(Store store, Window fatherWindow);
	public Window getWindow();
}
