package org.logSpin;

import java.util.HashMap;

public interface PluginContainer<T> {

    void addPlugin(String pluginId, T plugin);

    boolean contain(String pluginId);

    HashMap<String, T> getPlugins();
}
