package org.LogSpin.plugin;

import org.LogSpin.Plugin;
import org.LogSpin.PluginManager;

public class DefaultPluginManager implements PluginManager {
    PluginRegister pluginRegister = new PluginRegister();

    public PluginRegister getPluginRegister() {
        return pluginRegister;
    }

    @Override
    public Plugin getPluginById(String Id) {
        try {
            return (Plugin) pluginRegister.getPlugin(Id).pluginClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
