package org.logSpin.plugin;

import org.logSpin.Plugin;
import org.logSpin.Spin;

public class PluginId {
    private final String id;
    private final Class<? extends Plugin<Spin>> pluginClass;

    public PluginId(String id, Class<? extends Plugin<Spin>> pluginClass) {
        this.id = id;
        this.pluginClass = pluginClass;
    }

    public String getId() {
        return id;
    }

    public Class<? extends Plugin<Spin>> getPluginClass() {
        return pluginClass;
    }
}
