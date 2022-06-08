package logic.business.controllers;

import java.util.ArrayList;

import logic.business.Product;
import logic.business.auxiliars.SongBuilder;
import logic.util.Resolution;
import logic.util.SongPreForm;
import logic.util.VideoPreForm;

public class DBController {
	private ArrayList<Product> database;
	private ArrayList<Resolution> registeredResolutions;
	
	//Builders
	public DBController(ArrayList<Product> database)
	{
		this.database = database;
	}
	public DBController()
	{
		this.database = new ArrayList<Product>();
	}
	
	//Methods
	public ArrayList<String> getRegisteredResolutions()
	{
		ArrayList<String> resolutions = new ArrayList<String>();
		for(Resolution resolution : registeredResolutions)
		{
			resolutions.add(resolution.toString());
		}
		return resolutions;
	}
	
	public boolean addProduct(SongPreForm form){
		boolean exist = compareByTitle(form.getTitle());
		if(!exist){
			SongBuilder song = new SongBuilder();
			song.withTitle(form.getTitle());
			song.withGenre(form.getGenre());
			song.withInterpreter(form.getInterpreter());
			song.withCollaborators(form.getCollaborators());
			song.withDuration(form.getDuration());
			song.withFileSize(form.getFileSize());
			song.withAthor(form.getAuthor());
			song.withAlbum(form.getAlbum());
			database.add(song.build());
		}
		return exist;
	}
	public boolean addProduct(VideoPreForm form){
		boolean exist = false;
		return exist;
	}
	
	private boolean compareByTitle(String title){
		boolean exist = false;
		for(int i = 0; i < database.size() && !exist; i++){
			if(database.get(i).getTitle().equalsIgnoreCase(title)){
				exist = true;
			}
		}
		return exist;
	}
}
