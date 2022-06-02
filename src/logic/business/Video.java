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
	
	//Getters & Setters
	public String getResolution(){return resolution.toString();}
}
