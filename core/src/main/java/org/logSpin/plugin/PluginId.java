package org.logSpin.plugin;

public class PluginId {
    private final String id;
    private final Class<?> pluginClass;

    public PluginId(String id, Class<?> pluginClass) {
        this.id = id;
        this.pluginClass = pluginClass;
    }

    public String getId() {
        return id;
    }

    public Class<?> getPluginClass() {
        return pluginClass;
    }
}
