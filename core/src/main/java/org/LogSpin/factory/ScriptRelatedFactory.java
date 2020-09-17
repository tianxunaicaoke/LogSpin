package org.LogSpin.factory;


import org.LogSpin.core.LogSpin;
import org.LogSpin.core.PluginContainer;
import org.LogSpin.core.Spin;
import org.LogSpin.plugin.Plugin;
import org.LogSpin.script.CompileScriptHelper;
import org.LogSpin.script.ScriptRunner;
import org.LogSpin.script.ScriptSourceReader;

public class ScriptRelatedFactory {

    public ScriptRunner provideScriptRunner(){
     return new ScriptRunner(provideCompileScriptHelper(),provideScriptSourceReader());
    }

    public CompileScriptHelper provideCompileScriptHelper(){
        return new CompileScriptHelper();
    }

    public ScriptSourceReader provideScriptSourceReader(){
        return new ScriptSourceReader();
    }

    public Spin provideSpin(){
        return new LogSpin(providePluginContainer(),provideScriptRunner());
    }

    public PluginContainer<Plugin> providePluginContainer(){
        return new PluginContainer<Plugin>();
    }
}
