package org.logSpin.plugin;

import org.logSpin.Plugin;
import org.logSpin.PluginContainer;
import org.logSpin.Spin;

import java.util.HashMap;

public class DefaultPluginContainer implements PluginContainer<Plugin<Spin>> {
    private final HashMap<String, Plugin<Spin>> plugins = new HashMap<>();

    public void addPlugin(String pluginId, Plugin<Spin> plugin) {
        plugins.put(pluginId, plugin);
    }

    @Override
    public boolean contain(String pluginId) {
        return plugins.get(pluginId) != null;
    }

    public HashMap<String, Plugin<Spin>> getPlugins() {
        return plugins;
    }
}
