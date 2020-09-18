package reflect;

public class DefaultInstanceCreator implements InstanceCreator {
    @Override
    public <T> T newInstance(Class<? extends T> classType, Object... parameters) {
        return null;
    }
}
