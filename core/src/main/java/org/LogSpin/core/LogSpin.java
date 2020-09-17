package org.LogSpin.core;


import org.LogSpin.plugin.Plugin;
import org.LogSpin.script.ScriptRunner;

public class LogSpin implements Spin {

    PluginContainer<Plugin> pluginContainer;
    ScriptRunner scriptRunner;

    public LogSpin(PluginContainer<Plugin> pluginContainer, ScriptRunner scriptRunner) {
        this.pluginContainer = pluginContainer;
        this.scriptRunner = scriptRunner;
    }

    @Override
    public void configure(String[] arg) {
        scriptRunner.runScriptToConfigSpin(arg);
    }

    @Override
    public void analyse() {

    }
}
