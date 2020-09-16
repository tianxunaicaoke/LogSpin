package factory;

import core.LogSpin;
import core.PluginContainer;
import core.Spin;
import plugin.Plugin;
import script.CompileScriptHelper;
import script.ScriptRunner;
import script.ScriptSourceReader;

public class ScriptRelatedFactory {

    public  ScriptRunner provideScriptRunner(){
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
