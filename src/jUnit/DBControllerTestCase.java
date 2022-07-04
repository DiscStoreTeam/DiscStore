package jUnit;

import static org.junit.Assert.*;
import interfaces.util.SongPreForm;
import interfaces.util.VideoPreForm;
import logic.business.controllers.DBController;
import logic.business.core.Store;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBControllerTestCase {
	
	DBController controller;

	@Before
	public void setUp() throws Exception {
		Store store = new Store();
		controller = store.getDatabaseController();
	}

	@After
	public void tearDown() throws Exception {
		controller = null;
	}

	@Test
	public void testAddSongFail() {
		SongPreForm form = new SongPreForm();
		form.setTitle("Lagrimas Desordenadas");
		form.setGenre("Romantico");
		form.setDuration(3);
		form.setAuthor("Melendi");
		form.setInterpreter("Melendi");
		form.setAlbum("Lagrimas Desordenadas");
		form.setFileSize(0);
		assertTrue(controller.addProduct(form));
	}
	
	@Test
	public void testAddSongSucced () {
		SongPreForm form = new SongPreForm();
		form.setTitle("Numb");
		form.setGenre("Rock");
		form.setDuration(3);
		form.setAuthor("Linkin Park");
		form.setInterpreter("Linkin Park");
		form.setAlbum("Meteora");
		form.setFileSize(0);
		assertFalse(controller.addProduct(form));
	}
	
	@Test
	public void testAddVideoFail() {
		VideoPreForm form = new VideoPreForm();
		form.setTitle("Lagrimas Desordenadas");
		form.setGenre("Romantico");
		form.setDuration(3);
		form.setInterpreter("Melendi");
		form.setFileSize(0);
		form.setResolution(1, 2);
		assertTrue(controller.addProduct(form));
	}
	
	@Test
	public void testAddVideoSucced() {
		VideoPreForm form = new VideoPreForm();
		form.setTitle("Numb");
		form.setGenre("Rock");
		form.setDuration(3);
		form.setInterpreter("Linkin Park");
		form.setFileSize(0);
		form.setResolution(1, 2);
		assertFalse(controller.addProduct(form));
	}

}
