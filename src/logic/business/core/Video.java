package logic.business.core;

import logic.util.Resolution;

public class Video extends Product {
	private Resolution resolution;
	
	//Builders
	public Video(String title, String genre, int duration, String interpreter, String collaborators, int fileSize, Resolution resolution, int id) 
	{
		super(title, genre, duration, interpreter, collaborators, fileSize, id);
		this.resolution = new Resolution(resolution);
	}
	public Video(Video video)
	{
		super((Product)video);
		this.resolution = new Resolution(video.resolution);
	}
	public Video(int id){
		super(id);
		this.resolution = new Resolution();
	}
	
	//Methods
	
	//Getters & Setters
	public String getResolution(){return resolution.toString();}
	public void setResolution(Resolution resolution){
		this.resolution = new Resolution(resolution);
	}
}
