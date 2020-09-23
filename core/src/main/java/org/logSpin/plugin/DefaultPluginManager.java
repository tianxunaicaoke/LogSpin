package org.logSpin.plugin;

import org.logSpin.Plugin;
import org.logSpin.PluginContainer;
import org.logSpin.PluginManager;

public class DefaultPluginManager implements PluginManager {
    private final PluginRegister pluginRegister = new PluginRegister();
    private final PluginContainer<Plugin<?>> pluginContainer;

    public DefaultPluginManager(PluginContainer<Plugin<?>> pluginContainer ){
        this.pluginContainer = pluginContainer;
    }

    public PluginRegister getPluginRegister() {
        return pluginRegister;
    }

    @Override
    public Plugin<?> getPluginById(String Id) {
        try {
            return (Plugin<?>) pluginRegister.getPlugin(Id).getPluginClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PluginContainer<? extends Plugin<?>> getPluginContainer() {
        return pluginContainer;
    }


}
