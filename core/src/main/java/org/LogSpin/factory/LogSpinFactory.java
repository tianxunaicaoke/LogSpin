package org.LogSpin.factory;


import org.LogSpin.Plugin;
import org.LogSpin.core.LogSpin;
import org.LogSpin.PluginContainer;
import org.LogSpin.plugin.PluginRegister;
import org.LogSpin.script.ScriptDelegate;
import org.LogSpin.Spin;
import org.LogSpin.plugin.DefaultPluginContainer;
import org.LogSpin.script.*;

public class LogSpinFactory {
    PluginContainer<Plugin<?>> pluginPluginContainer;
    Spin spin;

    public LogSpinFactory() {
        this.pluginPluginContainer = new DefaultPluginContainer<>();
        ScriptDelegate scriptDelegate = provideScriptDelegate();
        this.spin = new LogSpin(pluginPluginContainer, provideScriptRunner(scriptDelegate));
        scriptDelegate.setSpin(spin);
    }

    public ScriptRunner provideScriptRunner(ScriptDelegate scriptDelegate) {
        return new ScriptRunner(provideCompileScriptHelper(),
                provideScriptSourceReader(),
                scriptDelegate);
    }

    public ScriptDelegate provideScriptDelegate() {
        return new DefaultScriptDelegate();
    }

    public CompileScriptHelper provideCompileScriptHelper() {
        return new CompileScriptHelper();
    }

    public ScriptSourceReader provideScriptSourceReader() {
        return new ScriptSourceReader();
    }

    public Spin provideSpin() {
        return spin;
    }
}
