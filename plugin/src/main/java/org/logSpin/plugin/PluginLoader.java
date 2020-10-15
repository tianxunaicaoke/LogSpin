package org.logSpin.plugin;

import org.logSpin.AndroidPlugin;
import org.logSpin.Plugin;
import org.logSpin.Spin;

public class PluginLoader {
    PluginRegister pluginRegister;

    public PluginLoader(PluginRegister pluginRegister) {
        this.pluginRegister = pluginRegister;
    }

    public void loadAllInternalPlugin() {
        pluginRegister.register("BasePlugin", BasePlugin.class);
        pluginRegister.register("AndroidPlugin", AndroidPlugin.class);
    }

    @SuppressWarnings("unused")
    public void addExternalPlugin(String pluginId,Class<? extends Plugin<Spin>> clazz){
        pluginRegister.register(pluginId,clazz);
    }
}
