package org.LogSpin.plugin;

import org.LogSpin.Plugin;
import org.LogSpin.PluginContainer;

import java.util.ArrayList;
import java.util.List;

public class DefaultPluginContainer<T extends Plugin> implements PluginContainer<T> {
    List<T> plugins = new ArrayList<>();

    public void addPlugin(T plugin) {
        plugins.add(plugin);
    }

    public List<T> getPlugins() {
        return plugins;
    }
}