package org.logSpin.plugin;

import org.logSpin.Plugin;
import org.logSpin.Spin;
import org.logSpin.dynamicJar.PluginJarHandler;
import org.logspin.echartplugin.EchartPlugin;

public class PluginLoader {
    PluginRegister pluginRegister;
    PluginHandler pluginHandler;

    public PluginLoader(PluginRegister pluginRegister) {
        this.pluginRegister = pluginRegister;
        this.pluginHandler = new PluginJarHandler();
    }

    public void loadAllInternalPlugin() {
        pluginRegister.register("BasePlugin", BasePlugin.class);
        pluginRegister.register("AndroidPlugin", AndroidPlugin.class);
        pluginRegister.register("EchartPlugin", EchartPlugin.class);
    }

    @SuppressWarnings("unused")
    public void loadExternalPlugin(String pluginId, Class<? extends Plugin<Spin>> clazz) {
        pluginRegister.register(pluginId, clazz);
    }

    public void loadExternalPluginUnderFolder() {
        pluginHandler.getPlugins().forEach(this::loadExternalPlugin);
    }
}
