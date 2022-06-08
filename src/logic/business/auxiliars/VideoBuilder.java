package logic.business.auxiliars;

import logic.business.Video;
import logic.util.Resolution;

public class VideoBuilder {
private Video video;
	
	//Builders
	public VideoBuilder(){
		video = new Video();
	}
	
	//Methods
	public Video build(){return video;}
	
	public VideoBuilder withTitle(String title){
		video.setTitle(title);
		return this;
	}
	public VideoBuilder withGenre(String genre){
		video.setGenre(genre);
		return this;
	}
	public VideoBuilder withDuration(Integer duration){
		video.setDuration(duration.intValue());
		return this;
	}
	public VideoBuilder withInterpreter(String interpreter){
		video.setInterpreter(interpreter);
		return this;
	}
	public VideoBuilder withCollaborators(String collaborators){
		video.setCollaborators(collaborators);
		return this;
	}
	public VideoBuilder withFileSize(Integer fileSize){
		video.setFileSize(fileSize.intValue());
		return this;
	}
	public VideoBuilder withResolution(Resolution resolution){
		video.setResolution(resolution);
		return this;
	}
}
