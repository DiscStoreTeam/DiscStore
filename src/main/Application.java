package main;

import interfaces.gui.workflow.ChangeCredentialHandler;
import interfaces.gui.workflow.LoginHandler;
import interfaces.gui.workflow.WindowHandler;

import java.awt.Window;
import java.util.HashMap;

import logic.business.core.Store;

public final class Application {
	public enum WindowType{login, credentials;}
	private static HashMap<WindowType, WindowHandler> handlerMap;
	
	private final static Store store = new Store();
	
	public static void main(String[] args) {
		initialize();
		start();
	}
	
	public static void initialize(){
		handlerMap = new HashMap<WindowType, WindowHandler>();
		handlerMap.put(WindowType.login, new LoginHandler());
		handlerMap.put(WindowType.credentials, new ChangeCredentialHandler());
	}
	
	public static void changeWindow(Window actualWindow,WindowType nextWindow){
		WindowHandler handler = handlerMap.get(nextWindow);
		handler.open(store);
		actualWindow.dispose();
	}
	
	public static void start(){
		WindowHandler handler = handlerMap.get(WindowType.login);
		handler.open(store);
	}
}
