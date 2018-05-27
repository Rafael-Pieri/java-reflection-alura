package br.com.alura.unit;

import org.junit.Before;
import org.junit.Test;

import br.com.alura.reflection.Validator;
import br.com.alura.reflection.model.User;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MethodsTest {

	private User user;

	@Before
	public void createAnUser() {
		user = new User();
		user.setEmail("com@arroba.com");
		user.setPassword("123456789");
		user.setLogin("loginok");
		user.setActive(true);
	}

	@Test
	public void mustBeAValidObject() {
		assertTrue(Validator.isObjectValid(user));
	}

	@Test
	public void mustBeAnInvalidObject() {
		user.setLogin("invalidlogin");
		assertFalse(Validator.isObjectValid(user));
	}
}