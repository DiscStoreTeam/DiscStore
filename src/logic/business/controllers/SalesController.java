package logic.business.controllers;

import java.util.ArrayList;


import logic.business.abstractions.Disc;
import logic.business.abstractions.IProduct;
import logic.business.auxiliars.CDManager;
import logic.business.auxiliars.DVDManager;
import logic.business.auxiliars.SCManager;
import logic.business.auxiliars.SellReports;
import logic.business.auxiliars.ShoppingCar;
import logic.business.core.Song;
import logic.business.core.Video;
import logic.business.core.Worker;
import logic.util.Resolution;

public class SalesController {
	//Te dejo de tarea cambiar la estructura para q existan 2 listas, una de canciones y otra de videos, asi cada Manager no tiene
	//q trabajar con informacion q no le toca
	private ArrayList<Song> songsList;
	private ArrayList<Video> videosList;
	private ArrayList<SellReports> sellReports;
	private ArrayList<Disc> history;
	private ShoppingCar shoppingCar;
	private Worker loggedWorker;
	private AccessController access;


	public SalesController(ArrayList<Song> songDatabase, ArrayList<Video> videoDatabase, AccessController access)
	{	
		this.shoppingCar = new ShoppingCar();
		this.songsList = new ArrayList<Song>(songDatabase);
		this.videosList = new ArrayList<Video>(videoDatabase);
		this.sellReports = new ArrayList<SellReports>();
		this.history = new ArrayList<Disc>();
		this.access = access;
		this.loggedWorker = loggedWorker;
		
		//String title, String genre, int duration, String interpreter, String collaborators, int fileSize, String author, String album
		songsList.add(new Song("Lagrimas Desordenadas","Romantico",3,"Melendi","",0,"Melendi","Lagrimas Desordenadas", 0));
		songsList.add(new Song("Tu jardin con enanitos", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 1));
		songsList.add(new Song("Cheque al portamor", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 2));
		songsList.add(new Song("Tu lista de enemigos", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 3));
		songsList.add(new Song("Aprendiz de caballero", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 4));
		songsList.add(new Song("Autofotos", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 5));
		songsList.add(new Song("Mi Primer beso", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 6));
		songsList.add(new Song("La tortura de Lyss", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 7));
		songsList.add(new Song("De pequeño fue el coco", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 8));
		songsList.add(new Song("Gatos Celestes", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 9));
		songsList.add(new Song("De repente desperte", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 10));

		songsList.add(new Song("Barbie de extraradio", "", 0, "Melendi", "", 0, "Melendi", "Volvamos a empezar", 11));
		songsList.add(new Song("Llueve", "", 0, "Melendi", "", 0, "Melendi", "Volvamos a empezar", 12));
		songsList.add(new Song("Somos", "", 0, "Melendi", "", 0, "Melendi", "Volvamos a empezar", 13));
		songsList.add(new Song("Volvamos a empezar", "", 0, "Melendi", "", 0, "Melendi", "Volvamos a empezar", 14));

		songsList.add(new Song("Coronel", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Rarezas", 15));
		songsList.add(new Song("El tiempo", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Rarezas", 16));
		songsList.add(new Song("Vestido azul", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Rarezas", 17));
		songsList.add(new Song("Paris", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Rarezas", 18));

		songsList.add(new Song("Noche", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Guapa", 19));
		songsList.add(new Song("Muñeca de trapo", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Guapa", 20));
		songsList.add(new Song("Dulce Locura", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Guapa", 21));
		songsList.add(new Song("Apareces Tu", "", 0, "La Oreja de Van Gogh", "", 0, "La Oreja de Van Gogh", "Guapa", 22));

		songsList.add(new Song("Calma Pueblo", "", 0, "Calle 13", "", 0, "Calle 13", "Entren los que quieran", 23));
		songsList.add(new Song("La Vuelta al mundo", "", 0, "Calle 13", "", 0, "Calle 13", "Entren los que quieran", 24));
		songsList.add(new Song("Latinoamerica", "", 0, "Calle 13", "", 0, "Calle 13", "Entren los que quieran", 25));

		songsList.add(new Song("El Aguante", "", 0, "Calle 13", "", 0, "Calle 13", "Multi Viral", 26));
		songsList.add(new Song("Ojos de color sol", "", 0, "Calle 13", "", 0, "Calle 13", "Multi Viral", 27));
		songsList.add(new Song("Los idiotas", "", 0, "Calle 13", "", 0, "Calle 13", "Multi Viral", 28));
		
		//String title, String genre, int duration, String interpreter, String collaborators,
		//int fileSize, Resolution resolution, int id) 
		Resolution resolution = new Resolution(1,2);
		videosList.add(new Video("Lagrimas desordenadas","Romantico",0,"Melendi","-",0,resolution,0));
		videosList.add(new Video("Vuelve","Romantico",0,"Beret","-",0,resolution,1));
		videosList.add(new Video("Maquiavelico","Rap",0,"Canserbero","-",0,resolution,2));
		videosList.add(new Video("Dejarte de amar","Romantico",0,"Camila","-",0,resolution,3));
		videosList.add(new Video("Volar sin ti","Romantico",0,"Buena Fe","-",0,resolution,4));
		
		
	}

	public CDManager getCDManager(){
		return new CDManager(this, songsList);
	}
	public DVDManager getDVDManager(){
		return new DVDManager(this, videosList);
	}
	public SCManager getSCManager(){
		return new SCManager(this, shoppingCar);
	}

	public ArrayList<Video> getVideoList(){
		return videosList;
	}
	public ArrayList<Song> getSongsList(){
		return songsList;
	}
	public void sell(){
		getSCManager().sell();
	}
	public int getReportId(){
		return history.size()+1;
	}
	public void addHistory(IProduct item){
		history.add((Disc)item);
	}
	public void addSellReport(SellReports sellReport){
		sellReports.add(sellReport);
	}
	public ArrayList<SellReports> getSellReports(){
		return this.sellReports;
	}
	public Worker getLoggedWorker(){
		loggedWorker = access.getLoggedWorker();
		return loggedWorker;
	}
}


