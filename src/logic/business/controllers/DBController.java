package logic.business.controllers;

import interfaces.util.SongPreForm;
import interfaces.util.VideoPreForm;

import java.util.ArrayList;

import logic.business.auxiliars.SongBuilder;
import logic.business.auxiliars.VideoBuilder;
import logic.business.core.Product;
import logic.business.core.Song;
import logic.business.core.Video;
import logic.util.ProductType;
import logic.util.Resolution;

public class DBController {
	private ArrayList<Song> songDatabase;
	private ArrayList<Video> videoDatabase;
	private ArrayList<Resolution> registeredResolutions;
	
	//Builders
	public DBController(ArrayList<Song> songDatabase, ArrayList<Video> videoDatabase)
	{
		this.songDatabase = songDatabase;
		this.videoDatabase = videoDatabase;
		registeredResolutions = new ArrayList<Resolution>();
		registeredResolutions.add(new Resolution(800, 600));
		registeredResolutions.add(new Resolution(1280, 720));
		registeredResolutions.add(new Resolution(1920, 1080));
		registeredResolutions.add(new Resolution(2048, 1080));
		registeredResolutions.add(new Resolution(4096, 2160));
		initialize();
	}
	public DBController()
	{
		this.songDatabase = new ArrayList<Song>();
		this.videoDatabase = new ArrayList<Video>();
		registeredResolutions = new ArrayList<Resolution>();
		registeredResolutions.add(new Resolution(800, 600));
		registeredResolutions.add(new Resolution(1280, 720));
		registeredResolutions.add(new Resolution(1920, 1080));
		registeredResolutions.add(new Resolution(2048, 1080));
		registeredResolutions.add(new Resolution(4096, 2160));
		initialize();
	}
	
	//Methods
	public ArrayList<String> getRegisteredResolutions()
	{
		ArrayList<String> resolutions = new ArrayList<String>();
		for(Resolution resolution : registeredResolutions)
		{
			resolutions.add(resolution.toString());
		}
		return resolutions;
	}
	
	public boolean addProduct(SongPreForm form){
		boolean exist = compareByTitle(form.getTitle(), ProductType.song);
		if(!exist){
			SongBuilder song = new SongBuilder(songDatabase.size());
			song.withTitle(form.getTitle());
			song.withGenre(form.getGenre());
			song.withInterpreter(form.getInterpreter());
			song.withCollaborators(form.getCollaborators());
			song.withDuration(form.getDuration());
			song.withFileSize(form.getFileSize());
			song.withAthor(form.getAuthor());
			song.withAlbum(form.getAlbum());
			songDatabase.add(song.build());
		}
		return exist;
	}
	public boolean addProduct(VideoPreForm form){
		boolean exist = compareByTitle(form.getTitle(), ProductType.video);
		if(!exist){
			VideoBuilder video = new VideoBuilder(videoDatabase.size());
			video.withTitle(form.getTitle());
			video.withGenre(form.getGenre());
			video.withInterpreter(form.getInterpreter());
			video.withCollaborators(form.getCollaborators());
			video.withDuration(form.getDuration());
			video.withFileSize(form.getFileSize());
			video.withResolution(form.getResolution());
			videoDatabase.add(video.build());
		}
		return exist;
	}
	
	public void removeItem(int ID, ProductType type){
		if(type == ProductType.song){
			for(int i = 0; i < songDatabase.size(); i++){
				if(songDatabase.get(i).getID().intValue() == ID){
					songDatabase.remove(i);
				}
			}
		}
		else{
			for(int i = 0; i < videoDatabase.size(); i++){
				if(videoDatabase.get(i).getID().intValue() == ID){
					videoDatabase.remove(i);
				}
			}
		}
	}
	
	private boolean compareByTitle(String title, ProductType type){
		boolean exist = false;
		if(type == ProductType.song){
			for(int i = 0; i < songDatabase.size(); i++){
				if(songDatabase.get(i).getTitle().equalsIgnoreCase(title)){
					exist = true;
				}
			}
		}
		else if(type == ProductType.video){
			for(int i = 0; i < videoDatabase.size(); i++){
				if(videoDatabase.get(i).getTitle().equalsIgnoreCase(title)){
					exist = true;
				}
			}
		}
		return exist;
	}
	
	public ArrayList<Product> getProducts(){
		ArrayList<Product> products = new ArrayList<Product>();
		for(Song product : songDatabase){
			products.add(product);
		}
		for(Video product : videoDatabase){
			products.add(product);
		}
		return products;
	}
	
	private void initialize(){
		songDatabase.add(new Song("Lagrimas Desordenadas","Romantico",3,"Melendi","",0,"Melendi","Lagrimas Desordenadas", 0));
		songDatabase.add(new Song("Tu jardin con enanitos", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 1));
		songDatabase.add(new Song("Cheque al portamor", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 2));
		songDatabase.add(new Song("Tu lista de enemigos", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 3));
		songDatabase.add(new Song("Aprendiz de caballero", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 4));
		songDatabase.add(new Song("Autofotos", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 5));
		songDatabase.add(new Song("Mi Primer beso", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 6));
		songDatabase.add(new Song("La tortura de Lyss", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 7));
		songDatabase.add(new Song("De pequeño fue el coco", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 8));
		songDatabase.add(new Song("Gatos Celestes", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 9));
		songDatabase.add(new Song("De repente desperte", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 10));

		songDatabase.add(new Song("Barbie de extraradio", "", 0, "Melendi", "", 0, "Melendi", "Volvamos a empezar", 11));
		songDatabase.add(new Song("Llueve", "", 0, "Melendi", "", 0, "Melendi", "Volvamos a empezar", 12));
		songDatabase.add(new Song("Somos", "", 0, "Melendi", "", 0, "Melendi", "Volvamos a empezar", 13));
		songDatabase.add(new Song("Volvamos a empezar", "", 0, "Melendi", "", 0, "Melendi", "Volvamos a empezar", 14));

		songDatabase.add(new Song("Coronel", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Rarezas", 15));
		songDatabase.add(new Song("El tiempo", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Rarezas", 16));
		songDatabase.add(new Song("Vestido azul", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Rarezas", 17));
		songDatabase.add(new Song("Paris", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Rarezas", 18));

		songDatabase.add(new Song("Noche", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Guapa", 19));
		songDatabase.add(new Song("Muñeca de trapo", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Guapa", 20));
		songDatabase.add(new Song("Dulce Locura", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Guapa", 21));
		songDatabase.add(new Song("Apareces Tu", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Guapa", 22));

		songDatabase.add(new Song("Calma Pueblo", "", 0, "Calle 13", "", 0, "Calle 13", "Entren los que quieran", 23));
		songDatabase.add(new Song("La Vuelta al mundo", "", 0, "Calle 13", "", 0, "Calle 13", "Entren los que quieran", 24));
		songDatabase.add(new Song("Latinoamerica", "", 0, "Calle 13", "", 0, "Calle 13", "Entren los que quieran", 25));

		songDatabase.add(new Song("El Aguante", "", 0, "Calle 13", "", 0, "Calle 13", "Multi Viral", 26));
		songDatabase.add(new Song("Ojos de color sol", "", 0, "Calle 13", "", 0, "Calle 13", "Multi Viral", 27));
		songDatabase.add(new Song("Los idiotas", "", 0, "Calle 13", "", 0, "Calle 13", "Multi Viral", 28));
		
		//String title, String genre, int duration, String interpreter, String collaborators,
		//int fileSize, Resolution resolution, int id) 
		Resolution resolution = new Resolution(1,2);
		videoDatabase.add(new Video("Lagrimas desordenadas","Romantico",0,"Melendi","-",0,resolution,0));
		videoDatabase.add(new Video("Vuelve","Romantico",0,"Beret","-",0,resolution,1));
		videoDatabase.add(new Video("Maquiavelico","Rap",0,"Canserbero","-",0,resolution,2));
		videoDatabase.add(new Video("Dejarte de amar","Romantico",0,"Camila","-",0,resolution,3));
		videoDatabase.add(new Video("Volar sin ti","Romantico",0,"Buena Fe","-",0,resolution,4));
	}
	
	public void reaload(ArrayList<Song> songDatabase, ArrayList<Video> videoDatabase){
		this.songDatabase = songDatabase;
		this.videoDatabase = videoDatabase;
	}
}
