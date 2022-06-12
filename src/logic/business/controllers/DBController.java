package logic.business.controllers;

import interfaces.util.SongPreForm;
import interfaces.util.VideoPreForm;

import java.util.ArrayList;

import logic.business.auxiliars.SearchManager;
import logic.business.auxiliars.SongBuilder;
import logic.business.auxiliars.VideoBuilder;
import logic.business.core.Product;
import logic.business.core.Song;
import logic.business.core.Video;
import logic.util.ProductType;
import logic.util.Resolution;

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
		boolean exist = compareByTitle(form.getTitle(), ProductType.song);
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
		boolean exist = compareByTitle(form.getTitle(), ProductType.video);
		if(!exist){
			VideoBuilder video = new VideoBuilder();
			video.withTitle(form.getTitle());
			video.withGenre(form.getGenre());
			video.withInterpreter(form.getInterpreter());
			video.withCollaborators(form.getCollaborators());
			video.withDuration(form.getDuration());
			video.withFileSize(form.getFileSize());
			video.withResolution(form.getResolution());
		}
		return exist;
	}
	
	public void removeItem(String title, ProductType type){
		for(int i = 0; i < database.size(); i++){
			Product item = database.get(i);
			if(item.getTitle().equalsIgnoreCase(title)){
				switch (type) {
				case song:
					if(item instanceof Song){
						database.remove(item);
					}
					break;
				case video:
					if(item instanceof Video){
						database.remove(item);
					}
					break;
				}
			}
		}
	}
	
	public ArrayList<Song> searchSongs(String critery){
		ArrayList<Song> list = new ArrayList<Song>();
		
		SearchManager<Song> searcher = new SearchManager<Song>();
		//list = searcher.search(critery, database);
		
		return list;
	}
	public ArrayList<Video> searchVideos(String critery){
		ArrayList<Video> list = new ArrayList<Video>();
		
		SearchManager<Video> searcher = new SearchManager<Video>();
		//list = searcher.search(critery, database);
		
		return list;
	}
	
	private boolean compareByTitle(String title, ProductType type){
		boolean exist = false;
		for(int i = 0; i < database.size() && !exist; i++){
			if(database.get(i).getTitle().equalsIgnoreCase(title)){
				if(type == ProductType.song){
					if(database.get(i) instanceof Song){
						exist = true;
					}
				}
				else{
					if(database.get(i) instanceof Video){
						exist = true;
					}
				}
			}
		}
		return exist;
	}
}
