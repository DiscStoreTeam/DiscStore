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
			if(item.getTitle().equals(critery)){
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
			if(item.getGenre().equals(critery)){
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
			if(item.getInterpreter().equals(critery)){
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
			if(item.getCollaborators().equals(critery)){
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
			if(item.getAlbum().equals(critery)){
				list.add((E)item);
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byAuthor(String critery, ArrayList<E> database){
		ArrayList<E> list = new ArrayList<E>();
		for(int i = 0; i < database.size(); i++){
			Song item = (Song)database.get(i);
			if(item.getAuthor().equals(critery)){
				list.add((E)item);
			}
		}
		return list;
	}
}
