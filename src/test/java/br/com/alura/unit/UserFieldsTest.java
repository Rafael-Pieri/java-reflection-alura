package br.com.alura.unit;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

import br.com.alura.reflection.GeneratorXML;
import br.com.alura.reflection.model.User;

import static org.junit.Assert.assertEquals;

public class UserFieldsTest {

	private static final String EMPTY = "";
	
	private User user;
	private BufferedReader bufferedReader;

	@Before
	public void createUser() {
		user = new User();
		user.setLogin("rafael");
		user.setPassword("passwordrafael");
		user.setEmail("rafael@rafael.com");
		user.setRole("student");
		user.setActive(true);
	}

	@Test
	public void generatesXmlUsingUserFields() throws Exception {
		String expectedXml = EMPTY;

		String generatedXml = GeneratorXML.getXML(user);

		FileReader fileReader = new FileReader("src/test/resources/user-fields.txt");
		bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready()) {
			if (EMPTY.equals(expectedXml)) {
				expectedXml = bufferedReader.readLine() + "\n";
			} else {
				expectedXml += bufferedReader.readLine() + "\n";
			}
		}

		assertEquals(expectedXml, generatedXml);
	}

}
