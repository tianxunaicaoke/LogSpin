package org.logSpin.launch;

import org.logSpin.Spin;
import org.logSpin.factory.LogSpinFactory;
import org.logSpin.plugin.DefaultPluginManager;
import org.logSpin.plugin.PluginLoader;
import org.logSpin.process.GroovySpinProcess;

public class LauncherHelper {
    private final GroovySpinProcess logProcess;
    private final Spin spin;
    private final PluginLoader pluginLoader;

    public LauncherHelper(){
        logProcess =  new GroovySpinProcess();
        spin =  new LogSpinFactory(logProcess).provideSpin();
        pluginLoader = new PluginLoader(((DefaultPluginManager)spin
                .getPluginManager())
                .getPluginRegister());
        init();
    }

    public void init(){
        pluginLoader.loadAllInternalPlugin();
        pluginLoader.loadExternalPluginUnderFolder();
    }

    public void run(String[] args){
        spin.configure(args);
    }
}
