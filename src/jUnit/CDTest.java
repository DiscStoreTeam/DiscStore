package jUnit;

import logic.business.abstractions.IProduct;
import logic.business.core.CD;
import logic.business.core.Song;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CDTest {
	private CD cd = new CD();
	private Song song;

	public void inicialize(){		
		cd.addItem(new Song("Lagrimas Desordenadas","Romantico",3,"Melendi","",0,"Melendi","Lagrimas Desordenadas", 0));
		cd.addItem((IProduct)new Song("Tu jardin con enanitos", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 1));
		cd.addItem(new Song("Cheque al portamor", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 2));
		cd.addItem(new Song("Tu lista de enemigos", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 3));
		cd.addItem(new Song("Aprendiz de caballero", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 4));
		cd.addItem(new Song("Autofotos", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 5));
		cd.addItem(new Song("Mi Primer beso", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 6));
		cd.addItem(new Song("La tortura de Lyss", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 7));
		cd.addItem(new Song("De pequeño fue el coco", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 8));
		cd.addItem(new Song("Gatos Celestes", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 9));
		cd.addItem(new Song("De repente desperte", "", 0, "Melendi", "", 0, "Melendi", "Lagrimas Desordenadas", 10));
		song = (Song) cd.getProducts().get(5);
		
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRemoveItem() {
		inicialize();
		System.out.println("Primera prueba \n"+cd.getContents().size());
		cd.removeItem(song);
		System.out.println(cd.getContents().size());
	}
	@Test
	public void testRemoveItemFail() {
		System.out.println("Segunda prueba \n"+cd.getContents().size());
		cd.removeItem(song);
		System.out.println(cd.getContents().size());
	}
	
	public void testNoFind() {
		inicialize();
		Song a = new Song("Prueba", "", 0, "Prueba", "", 0, "Prueba", "Disco Prueba", 10);
		System.out.println("Tercera prueba \n"+cd.getContents().size());
		cd.removeItem(a);
		System.out.println(cd.getContents().size());
	}

}
