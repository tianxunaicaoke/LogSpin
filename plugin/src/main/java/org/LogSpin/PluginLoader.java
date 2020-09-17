package org.LogSpin;

import org.LogSpin.plugin.PluginRegister;

public class PluginLoader {
    PluginRegister pluginRegister;
    public PluginLoader(PluginRegister pluginRegister){
        this.pluginRegister = pluginRegister;
    }
    public void loadAllPlugin(){
        pluginRegister.register("BasePlugin", BasePlugin.class);
    }
}
