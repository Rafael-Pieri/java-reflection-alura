package br.com.alura.reflection;

import br.com.alura.exception.ReflectionException;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Mapper {

    private Map<Class<?>, Class<?>> map = new HashMap<>();

    public void load(String fileName) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(fileName));

            for (Object key : properties.keySet()) {
                Class<?> interf = Class.forName(key.toString());
                Class<?> impl = Class.forName(properties.get(key).toString());

                if (!interf.isInterface()) {
                    throw new ReflectionException("The " + interf.getName() + "type is not an interface.");
                }

                if (!interf.isAssignableFrom(impl)) {
                    throw new ReflectionException("The " + impl.getName() + "class doesn't implement the interface "
                        + interf.getName());
                }

                map.put(interf, impl);
            }
        } catch (Exception exception) {
            throw new ReflectionException("Error to load file. ", exception);
        }
    }

    public Class<?> getImplementation(Class<?> interf) {
        return map.get(interf);
    }

    public <E> E getInstance(Class<E> interf, Object... params) {
        Class<?> impl = map.get(interf);
        Class<?>[] constructorTypes = new Class<?>[params.length];
        Object newInstance;

        try {
            for (int i = 0; i < constructorTypes.length; i++) {
                constructorTypes[i] = params[i].getClass();
            }

            newInstance = impl.getConstructor(constructorTypes).newInstance(params);
        } catch (Exception exception) {
            throw new ReflectionException("Error to get instance. ", exception);
        }

        return (E) newInstance;
    }
}