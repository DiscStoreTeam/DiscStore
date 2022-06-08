package interfaces.util;

import logic.util.Resolution;
import logic.util.Validator;

public class VideoPreForm {
	private String title;
	private String genre;
	private Integer duration;
	private String interpreter;
	private String collaborators;
	private Integer fileSize;
	private Resolution resolution;
	
	public VideoPreForm() {}

	public String getTitle() {return title;}
	public VideoPreForm setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getGenre() {return genre;}
	public VideoPreForm setGenre(String genre) {
		this.genre = genre;
		return this;
	}
	
	public Integer getDuration() {return duration;}
	public VideoPreForm setDuration(Integer duration) {
		this.duration = (Validator.positiveNumber(duration) ? duration : 1);
		return this;
	}
	
	public String getInterpreter() {return interpreter;}
	public VideoPreForm setInterpreter(String interpreter) {
		this.interpreter = interpreter;
		return this;
	}
	
	public String getCollaborators() {return collaborators;}
	public VideoPreForm setCollaborators(String collaborators) {
		this.collaborators = collaborators;
		return this;
	}
	
	public Integer getFileSize() {return fileSize;}
	public VideoPreForm setFileSize(Integer fileSize) {
		this.fileSize = (Validator.positiveNumber(fileSize) ? fileSize : 1);
		return this;
	}
	
	public Resolution getResolution(){return resolution;}
	public VideoPreForm setResolution(int height, int width){
		if(!Validator.positiveNumber(height))
			height = 1;
		if(!Validator.positiveNumber(width))
			width = 1;
		resolution = new Resolution(height, width);
		return this;
	}
}
