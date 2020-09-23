package org.logSpin.factory;


import org.logSpin.Plugin;
import org.logSpin.LogProcess;
import org.logSpin.core.LogSpin;
import org.logSpin.PluginContainer;
import org.logSpin.script.ScriptDelegate;
import org.logSpin.Spin;
import org.logSpin.plugin.DefaultPluginContainer;
import org.logSpin.script.*;

public class LogSpinFactory {
    private final Spin spin;

    public LogSpinFactory(LogProcess logProcess) {
        ScriptDelegate scriptDelegate = provideScriptDelegate();
        this.spin = new LogSpin(providePluginContainer(), provideScriptRunner(scriptDelegate), logProcess);
        scriptDelegate.setSpin(spin);
    }

    public ScriptRunner provideScriptRunner(ScriptDelegate scriptDelegate) {
        return new ScriptRunner(provideCompileScriptHelper(),
                provideScriptSourceReader(),
                scriptDelegate);
    }

    public PluginContainer<Plugin<?>> providePluginContainer(){
        return new DefaultPluginContainer<>();
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
