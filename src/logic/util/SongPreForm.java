package logic.util;

public class SongPreForm {
	private String title;
	private String genre;
	private Integer duration;
	private String interpreter;
	private String collaborators;
	private Integer fileSize;
	private String author;
	private String album;
	
	public SongPreForm(){}

	public String getTitle() {return title;}
	public SongPreForm setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getGenre() {return genre;}
	public SongPreForm setGenre(String genre) {
		this.genre = genre;
		return this;
	}
	
	public Integer getDuration() {return duration;}
	public SongPreForm setDuration(Integer duration) {
		this.duration = (Validator.positiveNumber(duration) ? duration : 1);
		return this;
	}
	
	public String getInterpreter() {return interpreter;}
	public SongPreForm setInterpreter(String interpreter) {
		this.interpreter = interpreter;
		return this;
	}
	
	public String getCollaborators() {return collaborators;}
	public SongPreForm setCollaborators(String collaborators) {
		this.collaborators = collaborators;
		return this;
	}
	
	public Integer getFileSize() {return fileSize;}
	public SongPreForm setFileSize(Integer fileSize) {
		this.fileSize = (Validator.positiveNumber(fileSize) ? fileSize : 1);
		return this;
	}
	
	public String getAuthor() {return author;}
	public SongPreForm setAuthor(String author) {
		this.author = author;
		return this;
	}

	public String getAlbum() {return album;}
	public SongPreForm setAlbum(String album) {
		this.album = album;
		return this;
	}
}
