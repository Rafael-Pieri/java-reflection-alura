package br.com.alura.unit;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import br.com.alura.reflection.Mapper;
import br.com.alura.reflection.interfaces.ExampleInterface;

public class InterfaceTest {

	@Test
	public void getClassThatImplementsTheInterface() {
		Mapper mapper = new Mapper();
		mapper.load("src/main/resources/classes.prop");

		assertEquals("class java.util.ArrayList", mapper.getImplementation(List.class).toString());
		assertEquals("class java.util.HashMap", mapper.getImplementation(Map.class).toString());

		List<?> list = mapper.getInstance(List.class);

		assertEquals("class java.util.ArrayList", list.getClass().toString());

		assertEquals("interface br.com.alura.reflection.interfaces.ExampleInterface",
				ExampleInterface.class.toString());

		ExampleInterface exampleInterface = mapper.getInstance(ExampleInterface.class, "test", 1);

		assertEquals("class br.com.alura.reflection.ExampleClass", exampleInterface.getClass().toString());
	}
}