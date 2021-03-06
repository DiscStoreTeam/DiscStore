package main;

import interfaces.gui.workflow.ChangeCredentialHandler;
import interfaces.gui.workflow.ChangeManagerHandler;
import interfaces.gui.workflow.ChangePropertiesHandler;
import interfaces.gui.workflow.AddProductHandler;
import interfaces.gui.workflow.DeleteProductHandler;
import interfaces.gui.workflow.FireWorkerHandler;
import interfaces.gui.workflow.HireWorkerHandler;
import interfaces.gui.workflow.LoginHandler;
import interfaces.gui.workflow.MainHandler;
import interfaces.gui.workflow.SalesHandler;
import interfaces.gui.workflow.ShoppingcarHandler;
import interfaces.gui.workflow.WindowHandler;

import java.awt.Window;
import java.util.HashMap;

import logic.business.core.Store;

public final class Application {
	public enum WindowType{login, credentials, main, sales, properties, newProduct, shoppingcar, deleteProduct, hireWorker, fireWorker, changeManager;}
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
		handlerMap.put(WindowType.main, new MainHandler());
		handlerMap.put(WindowType.sales, new SalesHandler());
		handlerMap.put(WindowType.properties, new ChangePropertiesHandler());
		handlerMap.put(WindowType.newProduct, new AddProductHandler());
		handlerMap.put(WindowType.shoppingcar, new ShoppingcarHandler());
		handlerMap.put(WindowType.deleteProduct, new DeleteProductHandler());
		handlerMap.put(WindowType.hireWorker, new HireWorkerHandler());
		handlerMap.put(WindowType.fireWorker, new FireWorkerHandler());
		handlerMap.put(WindowType.changeManager, new ChangeManagerHandler());
	}
	
	public static void changeWindow(Window actualWindow,WindowType nextWindow){
		WindowHandler handler = handlerMap.get(nextWindow);
		handler.open(store);
		actualWindow.dispose();
	}
	
	public static void openChildWindow(Window actualWindow, WindowType nextWindow){
		WindowHandler handler = handlerMap.get(nextWindow);
		handler.open(store);
	}
	
	public static void start(){
		WindowHandler handler = handlerMap.get(WindowType.login);
		handler.open(store);
	}
}
