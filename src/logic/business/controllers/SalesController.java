package logic.business.controllers;

import java.util.ArrayList;

import logic.business.abstractions.Disc;
import logic.business.auxiliars.CDManager;
import logic.business.auxiliars.DVDManager;
import logic.business.auxiliars.SCManager;
import logic.business.auxiliars.SearchManager;
import logic.business.auxiliars.ShoppingCar;
import logic.business.core.Product;
import logic.business.core.Song;
import logic.business.core.Video;

public class SalesController {
	//Te dejo de tarea cambiar la estructura para q existan 2 listas, una de canciones y otra de videos, asi cada Manager no tiene
	//q trabajar con informacion q no le toca
	private ArrayList<Song> songsList;
	private ArrayList<Video> videosList;
	private ArrayList<Integer> sellReports;
	private ShoppingCar shoppingCar;


	public SalesController(ArrayList<Product> database)
	{	
		this.shoppingCar = new ShoppingCar();
		this.songsList = new ArrayList<Song>();
		this.videosList = new ArrayList<Video>();
		this.sellReports = new ArrayList<Integer>();
		arrange(database);
		
		//String title, String genre, int duration, String interpreter, String collaborators, int fileSize, String author, String album
		songsList.add( new Song("Lagrimas Desordenadas","Romantico",3,"Melendi","",0,"Melendi","Lagrimas Desordenadas"));
		songsList.add(new Song("Tu jardin con enanitos", "", 0, "", "", 0, "Melendi", "Lagrimas Desordenadas"));
		songsList.add(new Song("Cheque al portamor", "", 0, "", "", 0, "Melendi", "Lagrimas Desordenadas"));
		songsList.add(new Song("Tu lista de enemigos", "", 0, "", "", 0, "Melendi", "Lagrimas Desordenadas"));
		songsList.add(new Song("Aprendiz de caballero", "", 0, "", "", 0, "Melendi", "Lagrimas Desordenadas"));
		songsList.add(new Song("Autofotos", "", 0, "", "", 0, "Melendi", "Lagrimas Desordenadas"));
		songsList.add(new Song("Mi Primer beso", "", 0, "", "", 0, "Melendi", "Lagrimas Desordenadas"));
		songsList.add(new Song("La tortura de Lyss", "", 0, "", "", 0, "Melendi", "Lagrimas Desordenadas"));
		songsList.add(new Song("De pequeño fue el coco", "", 0, "", "", 0, "Melendi", "Lagrimas Desordenadas"));
		songsList.add(new Song("Gatos Celestes", "", 0, "", "", 0, "Melendi", "Lagrimas Desordenadas"));
		songsList.add(new Song("De repente desperte", "", 0, "", "", 0, "Melendi", "Lagrimas Desordenadas"));

		songsList.add(new Song("Barbie de extraradio", "", 0, "", "", 0, "Melendi", "Volvamos a empezar"));
		songsList.add(new Song("Llueve", "", 0, "", "", 0, "Melendi", "Volvamos a empezar"));
		songsList.add(new Song("Somos", "", 0, "", "", 0, "Melendi", "Volvamos a empezar"));
		songsList.add(new Song("Volvamos a empezar", "", 0, "", "", 0, "Melendi", "Volvamos a empezar"));

		songsList.add(new Song("Coronel", "", 0, "", "", 0, "La Oreja de Van Gogh", "Rarezas"));
		songsList.add(new Song("El tiempo", "", 0, "", "", 0, "La Oreja de Van Gogh", "Rarezas"));
		songsList.add(new Song("Vestido azul", "", 0, "", "", 0, "La Oreja de Van Gogh", "Rarezas"));
		songsList.add(new Song("Paris", "", 0, "", "", 0, "La Oreja de Van Gogh", "Rarezas"));

		songsList.add(new Song("Noche", "", 0, "", "", 0, "La Oreja de Van Gogh", "Guapa"));
		songsList.add(new Song("Muñeca de trapo", "", 0, "", "", 0, "La Oreja de Van Gogh", "Guapa"));
		songsList.add(new Song("Dulce Locura", "", 0, "", "", 0, "La Oreja de Van Gogh", "Guapa"));
		songsList.add(new Song("Apareces Tu", "", 0, "", "", 0, "La Oreja de Van Gogh", "Guapa"));

		songsList.add(new Song("Calma Pueblo", "", 0, "", "", 0, "Calle 13", "Entren los que quieran"));
		songsList.add(new Song("La Vuelta al mundo", "", 0, "", "", 0, "Calle 13", "Entren los que quieran"));
		songsList.add(new Song("Latinoamerica", "", 0, "", "", 0, "Calle 13", "Entren los que quieran"));

		songsList.add(new Song("El Aguante", "", 0, "", "", 0, "Calle 13", "Multi Viral"));
		songsList.add(new Song("Ojos de color sol", "", 0, "", "", 0, "Calle 13", "Multi Viral"));
		songsList.add(new Song("Los idiotas", "", 0, "", "", 0, "Calle 13", "Multi Viral"));
	}

	public void addToShoppingList(Disc item){	
		if(!item.isEmpty()){
			item.setID(sellReports.size()+1);
			shoppingCar.addItem(item);
			sellReports.add(sellReports.size()+1);
		}
	}
	public CDManager getCDManager(){
		return new CDManager(this);
	}
	public DVDManager getDVDManager(){
		return new DVDManager(this);
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

	}


	//llena las listas de canciones y videos
	public void arrange(ArrayList<Product> database){
		for(int i=0; i<database.size();i++){
			if(database.get(i) instanceof Song){
				songsList.add((Song)database.get(i));
			}else{
				videosList.add((Video)database.get(i));
			}
		}
	}

}

