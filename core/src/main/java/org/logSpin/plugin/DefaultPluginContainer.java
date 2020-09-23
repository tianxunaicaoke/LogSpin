package org.logSpin.plugin;

import org.logSpin.Plugin;
import org.logSpin.PluginContainer;

import java.util.ArrayList;
import java.util.List;

public class DefaultPluginContainer<T extends Plugin<?>> implements PluginContainer<T> {
    private final List<T> plugins = new ArrayList<>();

    public void addPlugin(T plugin) {
        plugins.add(plugin);
    }

    public List<T> getPlugins() {
        return plugins;
    }
}
