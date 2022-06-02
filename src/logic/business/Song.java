package logic.business;

public class Song extends Product {
	private String author;
	private String album;

	public Song(String title, String genre, int duration, String interpreter, String collaborators, int fileSize, String author, String album) {
		super(title, genre, duration, interpreter, collaborators, fileSize);
		this.author = new String(author);
		this.album = new String(album);
	}
	public Song(Song song){
		super((Product)song);
		this.author = new String(song.getAuthor());
		this.album = new String(song.getAlbum());
	}
	

	public String getAuthor() {return author;}
	public String getAlbum() {return album;}
}
