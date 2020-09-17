package org.LogSpin.core;


import org.LogSpin.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class PluginContainer<T extends Plugin> {
    List<T> plugins = new ArrayList<>();

    public void addPlugin(T plugin) {
        plugins.add(plugin);
    }

    public List<T> getPlugins() {
        return plugins;
    }
}
