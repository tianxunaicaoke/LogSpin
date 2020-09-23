package org.logSpin.plugin;

public class PluginLoader {
    PluginRegister pluginRegister;

    public PluginLoader(PluginRegister pluginRegister) {
        this.pluginRegister = pluginRegister;
    }

    public void loadAllInternalPlugin() {
        pluginRegister.register("BasePlugin", BasePlugin.class);
    }

    @SuppressWarnings("unused")
    public void addExternalPlugin(String pluginId,Class<?> clazz){
        pluginRegister.register(pluginId,clazz);
    }
}
