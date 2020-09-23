package org.logSpin;

public interface PluginManager {
    Plugin<?> getPluginById(String Id);
    PluginContainer<? extends Plugin<?>> getPluginContainer();
}
