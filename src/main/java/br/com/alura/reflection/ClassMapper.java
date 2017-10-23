package br.com.alura.reflection;

import java.util.Map;

import br.com.alura.exception.ReflectionException;

public class ClassMapper {

	private Map<String, String> map;

	public Class<?> getClass(String key) {
		
		Class<?> forName;
		
		try {
			
			String value = map.get(key);

			if (value == null) {
				throw new ReflectionException("Invalid key.");
			}

			forName = Class.forName(value);
		
		} catch (Exception exception) {
			throw new ReflectionException("Error to get class. ", exception);
		}
				
		return forName;
	}

	public Object getObject(String chave) {
		
		Object newInstance;
		
		try {
			
			newInstance = getClass(chave).newInstance();
			
		} catch (Exception exception) {
			throw new ReflectionException("Error to get object. ", exception);
		}
		
		return newInstance;
	}

	public Object getObject(String key, Object[] params) {
		
		Object newInstance;
		
		try {
			
			Class<?>[] constructorTypes = new Class<?>[params.length];

			for (int i = 0; i < constructorTypes.length; i++) {
				constructorTypes[i] = params[i].getClass();
			}

			newInstance = getClass(key).getConstructor(constructorTypes).newInstance(params);

		} catch (Exception exception) {
			throw new ReflectionException("Error to get object with params. ", exception);
		}
		
		return newInstance;
	}

}
