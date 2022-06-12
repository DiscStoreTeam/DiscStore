package logic.business.auxiliars;

import java.util.ArrayList;

import logic.business.core.Product;
import logic.business.core.Song;

public class SearchManager<E> {
	
	//Builders
	public SearchManager() {
		super();
	}
	
	//Methods
	public ArrayList<E> search(String critery, ArrayList<E> database){
		//Manejar la excepcion de q E no sea Song o Video
		System.out.println("Buscador");
		ArrayList<E> list = new ArrayList<E>();
		list.addAll(byTitle(critery, database));
		list.addAll(byGenre(critery, database));
		list.addAll(byInterpreter(critery, database));
		list.addAll(byCollaborators(critery, database));
		if(!database.isEmpty()){
			if(database.get(0) instanceof Song){
				list.addAll(byAlbum(critery, database));
				list.addAll(byAuthor(critery, database));
			}
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<E> byTitle(String critery, ArrayList<E> database){
		ArrayList<E> list = new ArrayList<E>();
		for(int i = 0; i < database.size(); i++){
			Product item = (Product)database.get(i);
			if(item.getTitle().equalsIgnoreCase(critery)){
				System.out.println("a");
				list.add((E)item);
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byGenre(String critery, ArrayList<E> database){
		ArrayList<E> list = new ArrayList<E>();
		for(int i = 0; i < database.size(); i++){
			Product item = (Product)database.get(i);
			if(item.getGenre().equalsIgnoreCase(critery)){
				list.add((E)item);
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byInterpreter(String critery, ArrayList<E> database){
		ArrayList<E> list = new ArrayList<E>();
		for(int i = 0; i < database.size(); i++){
			Product item = (Product)database.get(i);
			if(item.getInterpreter().equalsIgnoreCase(critery)){
				list.add((E)item);
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byCollaborators(String critery, ArrayList<E> database){
		ArrayList<E> list = new ArrayList<E>();
		for(int i = 0; i < database.size(); i++){
			Product item = (Product)database.get(i);
			if(item.getCollaborators().equalsIgnoreCase(critery)){
				list.add((E)item);
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byAlbum(String critery, ArrayList<E> database){
		ArrayList<E> list = new ArrayList<E>();
		for(int i = 0; i < database.size(); i++){
			Song item = (Song)database.get(i);
			if(item.getAlbum().equalsIgnoreCase(critery)){
				if(!existingItem((E)item, list)){
					list.add((E)item);
				}
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byAuthor(String critery, ArrayList<E> database){
		ArrayList<E> list = new ArrayList<E>();
		for(int i = 0; i < database.size(); i++){
			Song item = (Song)database.get(i);
			if(item.getAuthor().equalsIgnoreCase(critery)){
				list.add((E)item);
			}
		}
		return list;
	}
	
	private boolean existingItem(E item, ArrayList<E> list){
		boolean exist = false;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) == item){
				exist = true;
			}
		}
		return exist;
	}
}
