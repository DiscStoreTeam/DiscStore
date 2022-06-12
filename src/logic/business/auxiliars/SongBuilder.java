package logic.business.auxiliars;

import logic.business.core.Song;

public class SongBuilder {
	private Song song;
	
	//Builders
	public SongBuilder(int id){
		song = new Song(id);
	}
	
	//Methods
	public Song build(){return song;}
	
	public SongBuilder withTitle(String title){
		song.setTitle(title);
		return this;
	}
	public SongBuilder withGenre(String genre){
		song.setGenre(genre);
		return this;
	}
	public SongBuilder withDuration(Integer duration){
		song.setDuration(duration.intValue());
		return this;
	}
	public SongBuilder withInterpreter(String interpreter){
		song.setInterpreter(interpreter);
		return this;
	}
	public SongBuilder withCollaborators(String collaborators){
		song.setCollaborators(collaborators);
		return this;
	}
	public SongBuilder withFileSize(Integer fileSize){
		song.setFileSize(fileSize.intValue());
		return this;
	}
	public SongBuilder withAthor(String	author){
		song.setAuthor(author);
		return this;
	}
	public SongBuilder withAlbum(String album){
		song.setAlbum(album);
		return this;
	}
	public SongBuilder withID(int id){
		return this;
	}
}

/*
public SongBuilder with(){
	return this;
}
*/
