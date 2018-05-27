package br.com.alura.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.com.alura.reflection.GeneratorXML;
import br.com.alura.reflection.model.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class UserFieldsTest {

    private User user;

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
    public void generatesXmlUsingUserFields() throws IOException {
        StringBuilder expectedXml = new StringBuilder();

        String generatedXml = GeneratorXML.getXML(user);

        FileReader fileReader = new FileReader("src/test/resources/user-fields.txt");

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                expectedXml.append(bufferedReader.readLine()).append("\n");
            }
        }

        assertEquals(expectedXml.toString(), generatedXml);
    }
}