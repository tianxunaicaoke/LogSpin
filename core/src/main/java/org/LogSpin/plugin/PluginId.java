package org.LogSpin.plugin;

public class PluginId {
    String id;
    Class<?> pluginClass;

    public PluginId(String id, Class<?> pluginClass) {
        this.id = id;
        this.pluginClass = pluginClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class<?> getPluginClass() {
        return pluginClass;
    }

    public void setPluginClass(Class<?> pluginClass) {
        this.pluginClass = pluginClass;
    }
}
