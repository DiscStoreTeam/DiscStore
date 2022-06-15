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
		byTitle(critery, database, list);
		byGenre(critery, database, list);
		byInterpreter(critery, database, list);
		byCollaborators(critery, database, list);
		if(!database.isEmpty()){
			if(database.get(0) instanceof Song){
				byAlbum(critery, database, list);
				byAuthor(critery, database, list);
			}
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<E> byTitle(String critery, ArrayList<E> database, ArrayList<E> list){
		for(int i = 0; i < database.size(); i++){
			Product item = (Product)database.get(i);
			if(item.getTitle().toLowerCase().contains(critery.toLowerCase())){
				if(!existingItem((E) item, list)){
					list.add((E)item);
				}
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byGenre(String critery, ArrayList<E> database, ArrayList<E> list){
		for(int i = 0; i < database.size(); i++){
			Product item = (Product)database.get(i);
			if(item.getGenre().toLowerCase().contains(critery.toLowerCase())){
				if(!existingItem((E) item, list)){
					list.add((E)item);
				}
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byInterpreter(String critery, ArrayList<E> database, ArrayList<E> list){
		for(int i = 0; i < database.size(); i++){
			Product item = (Product)database.get(i);
			if(item.getInterpreter().toLowerCase().contains(critery.toLowerCase())){
				if(!existingItem((E) item, list)){
					list.add((E)item);
				}
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byCollaborators(String critery, ArrayList<E> database, ArrayList<E> list){
		for(int i = 0; i < database.size(); i++){
			Product item = (Product)database.get(i);
			if(item.getCollaborators().toLowerCase().contains(critery.toLowerCase())){
				if(!existingItem((E) item, list)){
					list.add((E)item);
				}
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byAlbum(String critery, ArrayList<E> database, ArrayList<E> list){
		for(int i = 0; i < database.size(); i++){
			Song item = (Song)database.get(i);
			if(item.getAlbum().toLowerCase().contains(critery.toLowerCase())){
				if(!existingItem((E) item, list)){
					if(!existingItem((E) item, list)){
						list.add((E)item);
					}
				}
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	private ArrayList<E> byAuthor(String critery, ArrayList<E> database, ArrayList<E> list){
		for(int i = 0; i < database.size(); i++){
			Song item = (Song)database.get(i);
			if(item.getAuthor().toLowerCase().contains(critery.toLowerCase())){
				if(!existingItem((E) item, list)){
					list.add((E)item);
				}
			}
		}
		return list;
	}
	
	private boolean existingItem(E item, ArrayList<E> list){
		boolean exist = false;
		for(int i = 0; i < list.size(); i++){
			Product actualItem = (Product)list.get(i);
			Product thisItem = (Product) item;
			if(actualItem.getTitle().equalsIgnoreCase(thisItem.getTitle())){
				exist = true;
			}
		}
		return exist;
	}
}
