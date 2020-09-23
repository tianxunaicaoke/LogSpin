package org.logSpin;

import java.util.List;

public interface PluginContainer<T> {

    void addPlugin(T plugin) ;

    List<T> getPlugins();
}
