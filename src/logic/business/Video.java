package logic.business;

import logic.util.Resolution;

public class Video extends Product {
	private Resolution resolution;
	
	//Builders
	public Video(String title, String genre, int duration, String interpreter, String collaborators, int fileSize, Resolution resolution) 
	{
		super(title, genre, duration, interpreter, collaborators, fileSize);
		this.resolution = new Resolution(resolution);
	}
	public Video(Video video)
	{
		super((Product)video);
		this.resolution = new Resolution(video.resolution);
	}
	
	//Methods
	
	//Getters & Setters
	public String getResolution(){return resolution.toString();}
}
