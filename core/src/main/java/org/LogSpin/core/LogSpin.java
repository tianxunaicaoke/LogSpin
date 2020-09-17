package org.LogSpin.core;


import org.LogSpin.plugin.DefaultPluginManager;
import org.LogSpin.PluginContainer;
import org.LogSpin.Spin;
import org.LogSpin.Plugin;
import org.LogSpin.PluginManager;
import org.LogSpin.script.ScriptRunner;

public class LogSpin implements Spin {

    PluginContainer<Plugin> pluginContainer;
    ScriptRunner scriptRunner;
    PluginManager pluginManager;

    public LogSpin(PluginContainer<Plugin> pluginContainer, ScriptRunner scriptRunner) {
        this.pluginContainer = pluginContainer;
        this.scriptRunner = scriptRunner;
        this.pluginManager = new DefaultPluginManager();
    }

    @Override
    public void configure(String[] arg) {
        scriptRunner.runScriptToConfigSpin(arg);
    }

    @Override
    public void analyse() {

    }

    @Override
    public PluginContainer<Plugin> getPluginContainer() {
        return pluginContainer;
    }

    @Override
    public PluginManager getPluginManager() {
        return pluginManager;
    }
}
