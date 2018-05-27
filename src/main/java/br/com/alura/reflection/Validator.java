package br.com.alura.reflection;

import br.com.alura.exception.ReflectionException;
import java.lang.reflect.Method;

public class Validator {

	private Validator() {}

	public static boolean isObjectValid(Object obj) {
		boolean result = true;

		try {
			Class<?> clazz = obj.getClass();

			for (Method method : clazz.getMethods()) {
				if (method.getName().startsWith("is") && method.getReturnType() == boolean.class
						&& method.getParameterTypes().length == 0) {

					Boolean ret = (Boolean) method.invoke(obj);
					result = result && ret;
				}
			}
		} catch (Exception exception) {
			throw new ReflectionException("Error to valid object. ", exception);
		}

		return result;
	}
}