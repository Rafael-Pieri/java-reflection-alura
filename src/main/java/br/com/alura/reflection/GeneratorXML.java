package br.com.alura.reflection;

import br.com.alura.exception.ReflectionException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class GeneratorXML {

	private GeneratorXML() {}

    public static String getXML(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Class<?> clazz = obj.getClass();

            stringBuilder.append("<").append(clazz.getSimpleName()).append("> \n");

            for (Field field : clazz.getDeclaredFields()) {
                stringBuilder.append("<").append(field.getName()).append(">");
                field.setAccessible(true);
                stringBuilder.append(field.get(obj));
                stringBuilder.append("</").append(clazz.getName()).append("> \n");
            }

            stringBuilder.append("</").append(clazz.getSimpleName()).append("> \n");
        } catch (Exception exception) {
            throw new ReflectionException("Error to get XML.", exception);
        }

        return stringBuilder.toString();
    }
}