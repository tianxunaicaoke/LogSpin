package reflect;

public interface InstanceCreator {
    <T> T newInstance(Class<? extends T> classType, Object... parameters);
}
