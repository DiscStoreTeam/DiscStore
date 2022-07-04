package jUnit;

import static org.junit.Assert.*;
import logic.business.controllers.AccessController;
import logic.business.core.Store;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccessControllerTestCase {
	
	AccessController controller;

	@Before
	public void setUp() throws Exception {
		Store store = new Store();
		controller = store.getAccessController();
	}

	@After
	public void tearDown() throws Exception {
		controller = null;
	}

	@Test
	public void testLoginManager() {
		assertEquals(0, controller.login("Alicia", "12345678901"));
	}
	
	@Test
	public void testLoginWorker() {
		assertEquals(1, controller.login("Juan", "12345678901"));
	}
	
	@Test
	public void testLoginAdmin() {
		assertEquals(9999, controller.login("admin", "admin"));
	}
	
	@Test
	public void testLoginIncorrectPassword() {
		assertEquals(-1, controller.login("Alicia", "23232323232"));
	}
	
	@Test
	public void testLoginIncorrectCredentials() {
		assertEquals(-2, controller.login("Laura", "01010101011"));
	}
	
	@Test
	public void testCompareUsernameTrue() {
		controller.login("admin", "admin");
		assertTrue(controller.compareUsername("Alicia"));
	}
	
	@Test
	public void testCompareUsernameFalse() {
		controller.login("admin", "admin");
		assertFalse(controller.compareUsername("Carlos"));
	}
}
