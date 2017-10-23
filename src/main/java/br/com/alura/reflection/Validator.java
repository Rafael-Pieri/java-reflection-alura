package br.com.alura.reflection;

import java.lang.reflect.Method;

import br.com.alura.exception.ReflectionException;

public class Validator {

	private Validator() {

	}

	public static boolean validObject(Object obj) {
		boolean result = true;

		try {

			Class<?> clazz = obj.getClass();

			for (Method method : clazz.getMethods()) {
				if (method.getName().startsWith("valid") && method.getReturnType() == boolean.class
						&& method.getParameterTypes().length == 0) {

					Boolean ret = (Boolean) method.invoke(obj);
					result = result && ret.booleanValue();
				}
			}

		} catch (Exception exception) {
			throw new ReflectionException("Error to valid object. ", exception);
		}

		return result;
	}

	public static boolean validObjectExample(Object obj) {
		boolean result = true;

		try {
			Class<?> clazz = obj.getClass();

			for (Method method : clazz.getMethods()) {
				if (method.getName().startsWith("test") && method.getReturnType() == void.class
						&& method.getParameterTypes().length == 0) {

					Boolean ret;

					ret = (Boolean) method.invoke(obj);

					result = result && ret.booleanValue();
				}
			}

		} catch (Exception exception) {
			throw new ReflectionException("Error to valid object example. Error [%s]", exception);
		}

		return result;
	}

}
