package org.logSpin;

public interface PluginManager<T> {
    Plugin<T> getPluginById(String Id);
    PluginContainer<Plugin<T>> getPluginContainer();
    boolean contain(String id);
}
