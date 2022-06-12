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
	private ArrayList<Song> songDatabase;
	private ArrayList<Video> videoDatabase;
	private ArrayList<Resolution> registeredResolutions;
	
	//Builders
	public DBController(ArrayList<Song> songDatabase, ArrayList<Video> videoDatabase)
	{
		this.songDatabase = songDatabase;
		this.videoDatabase = videoDatabase;
		registeredResolutions = new ArrayList<Resolution>();
		registeredResolutions.add(new Resolution(800, 600));
		registeredResolutions.add(new Resolution(1280, 720));
		registeredResolutions.add(new Resolution(1920, 1080));
		registeredResolutions.add(new Resolution(2048, 1080));
		registeredResolutions.add(new Resolution(4096, 2160));
	}
	public DBController()
	{
		this.songDatabase = new ArrayList<Song>();
		this.videoDatabase = new ArrayList<Video>();
		registeredResolutions = new ArrayList<Resolution>();
		registeredResolutions.add(new Resolution(800, 600));
		registeredResolutions.add(new Resolution(1280, 720));
		registeredResolutions.add(new Resolution(1920, 1080));
		registeredResolutions.add(new Resolution(2048, 1080));
		registeredResolutions.add(new Resolution(4096, 2160));
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
			SongBuilder song = new SongBuilder(songDatabase.size());
			song.withTitle(form.getTitle());
			song.withGenre(form.getGenre());
			song.withInterpreter(form.getInterpreter());
			song.withCollaborators(form.getCollaborators());
			song.withDuration(form.getDuration());
			song.withFileSize(form.getFileSize());
			song.withAthor(form.getAuthor());
			song.withAlbum(form.getAlbum());
			songDatabase.add(song.build());
		}
		return exist;
	}
	public boolean addProduct(VideoPreForm form){
		boolean exist = compareByTitle(form.getTitle(), ProductType.video);
		if(!exist){
			VideoBuilder video = new VideoBuilder(videoDatabase.size());
			video.withTitle(form.getTitle());
			video.withGenre(form.getGenre());
			video.withInterpreter(form.getInterpreter());
			video.withCollaborators(form.getCollaborators());
			video.withDuration(form.getDuration());
			video.withFileSize(form.getFileSize());
			video.withResolution(form.getResolution());
			videoDatabase.add(video.build());
		}
		return exist;
	}
	/*
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
	}*/
	
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
		if(type == ProductType.song){
			for(int i = 0; i < songDatabase.size(); i++){
				if(songDatabase.get(i).getTitle().equalsIgnoreCase(title)){
					exist = true;
				}
			}
		}
		else if(type == ProductType.video){
			for(int i = 0; i < videoDatabase.size(); i++){
				if(videoDatabase.get(i).getTitle().equalsIgnoreCase(title)){
					exist = true;
				}
			}
		}
		return exist;
	}
}
