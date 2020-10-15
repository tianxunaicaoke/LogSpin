package org.logSpin.plugin;

import org.logSpin.Plugin;
import org.logSpin.PluginContainer;
import org.logSpin.PluginManager;
import org.logSpin.Spin;

public class DefaultPluginManager implements PluginManager<Spin> {
    private final PluginRegister pluginRegister = new PluginRegister();
    private final PluginContainer<Plugin<Spin>> pluginContainer;

    public DefaultPluginManager(PluginContainer<Plugin<Spin>> pluginContainer) {
        this.pluginContainer = pluginContainer;
    }

    public PluginRegister getPluginRegister() {
        return pluginRegister;
    }

    @Override
    public Plugin<Spin> getPluginById(String id) {
        try {
            return contain(id)
                    ? pluginContainer.getPlugins().get(id)
                    : pluginRegister.getPlugin(id).getPluginClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PluginContainer<Plugin<Spin>> getPluginContainer() {
        return pluginContainer;
    }

    @Override
    public boolean contain(String id) {
        return pluginContainer.contain(id);
    }
}
