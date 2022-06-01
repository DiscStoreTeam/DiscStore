package logic.business;

public class Video extends Audiovisual {
	private String resolution;
	
	public Video(String title, String genre, int duration, String interpreter, String collaborators, int fileSize) {
		super(title, genre, duration, interpreter, collaborators, fileSize);
	}
}
