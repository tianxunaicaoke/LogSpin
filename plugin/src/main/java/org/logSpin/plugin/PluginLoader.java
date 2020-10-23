package org.logSpin.plugin;

import org.logSpin.Plugin;
import org.logSpin.Spin;
import org.logSpin.dynamicJar.PluginJarHandler;

public class PluginLoader {
    PluginRegister pluginRegister;
    PluginJarHandler pluginJarHandler;

    public PluginLoader(PluginRegister pluginRegister) {
        this.pluginRegister = pluginRegister;
        this.pluginJarHandler = new PluginJarHandler();
    }

    public void loadAllInternalPlugin() {
        pluginRegister.register("BasePlugin", BasePlugin.class);
        pluginRegister.register("AndroidPlugin", AndroidPlugin.class);
    }

    @SuppressWarnings("unused")
    public void loadExternalPlugin(String pluginId,Class<? extends Plugin<Spin>> clazz){
        pluginRegister.register(pluginId,clazz);
    }
}
