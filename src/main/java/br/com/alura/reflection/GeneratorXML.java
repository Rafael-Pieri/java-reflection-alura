package br.com.alura.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import br.com.alura.exception.ReflectionException;

public class GeneratorXML {

	private GeneratorXML() {
		
	}
	
	public static String getXML(Object obj) {
		StringBuilder stringBuilder = new StringBuilder();

		try {
			
			Class<?> clazz = obj.getClass();

			stringBuilder.append("<" + clazz.getSimpleName() + "> \n");

			for (Field field : clazz.getDeclaredFields()) {
				stringBuilder.append("<" + field.getName() + ">");
				field.setAccessible(true);
				stringBuilder.append(field.get(obj));
				stringBuilder.append("</" + clazz.getName() + "> \n");
			}

			stringBuilder.append("</" + clazz.getSimpleName() + "> \n");

		} catch (Exception exception) {
			throw new ReflectionException("Error to get XML. ", exception);
		}
		
		return stringBuilder.toString();
	}

	public static Map<String, Object> attributeMap(Object obj) {
		Map<String, Object> map = new HashMap<>();

		try {
			
			Class<?> clazz = obj.getClass();

			for (Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
			}
			
		} catch (Exception exception) {
			throw new ReflectionException("Error to attribute map. ", exception);
		}
		
		return map;
	}
}
