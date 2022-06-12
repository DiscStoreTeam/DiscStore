package logic.business.core;

public class Song extends Product {
	private String author;
	private String album;

	//Builders
	public Song(String title, String genre, int duration, String interpreter, String collaborators, int fileSize, String author, String album, int id) {
		super(title, genre, duration, interpreter, collaborators, fileSize, id);
		this.author = new String(author);
		this.album = new String(album);
	}
	public Song(Song song){
		super((Product)song);
		this.author = new String(song.getAuthor());
		this.album = new String(song.getAlbum());
	}
	public Song(int id){
		super(id);
		author = new String();
		album = new String();
	}
	
	//Methods
	
	
	//Getters & Setters
	public String getAuthor() {return author;}
	public void setAuthor(String author){this.author = author;}
	public String getAlbum() {return album;}
	public void setAlbum(String album){this.album = album;}
}
