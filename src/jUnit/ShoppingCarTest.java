package jUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import logic.business.abstractions.Disc;
import logic.business.auxiliars.ShoppingCar;
import logic.business.core.CD;
import logic.business.core.Song;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCarTest {
	private CD cd;
	private ShoppingCar shoppingcar = new ShoppingCar();
	
	public void inicialize(){
		cd = new CD();
		cd.addSong(new Song("Lagrimas Desordenadas","Romantico",3,"Melendi","",0,"Melendi","Lagrimas Desordenadas", 0));
		shoppingcar.addItem(cd);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateCost() {	
		inicialize();
		double result = shoppingcar.calculateCost();
		assertEquals(15.0, result, result);
	}
	@Test
	public void testCalculateCostFail(){
		double result = shoppingcar.calculateCost();
		assertEquals(0.0, result , result);
	}

}
