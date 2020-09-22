package org.LogSpin.reflect;

public class DefaultInstanceCreator implements InstanceCreator {

    @Override
    public <T> T newInstance(Class<? extends T> classType, Object... parameters) {
        try {
            return classType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
