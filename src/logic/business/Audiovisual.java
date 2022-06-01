package logic.business;

public abstract class Audiovisual {
	private String title;
	private String genre;
	private int duration;
	private String interpreter;
	private String collaborators;
	private int fileSize;
	
	//Builders
	public Audiovisual(String title, String genre, int duration,String interpreter, String collaborators, int fileSize) {
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.interpreter = interpreter;
		this.collaborators = collaborators;
		this.fileSize = fileSize;
	}
	
	
	
	//Getters & Setters
	public String getTitle() {return title;}
	//public void setTitle(String title) {this.title = title;}
	public String getGenre() {return genre;}
	//public void setGenre(String genre) {this.genre = genre;}
	public int getDuration() {return duration;}
	//public void setDuration(int duration) {this.duration = duration;}
	public String getInterpreter() {return interpreter;}
	//public void setInterpreter(String interpreter) {this.interpreter = interpreter;}
	public String getCollaborators() {return collaborators;}
	//public void setCollaborators(String collaborators) {this.collaborators = collaborators;}
	public int getFileSize() {return fileSize;}
	//public void setFileSize(int fileSize) {this.fileSize = fileSize;}	
}
