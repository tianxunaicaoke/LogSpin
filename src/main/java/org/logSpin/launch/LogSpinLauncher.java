package org.logSpin.launch;


import org.logSpin.plugin.PluginLoader;
import org.logSpin.Spin;
import org.logSpin.factory.LogSpinFactory;
import org.logSpin.plugin.DefaultPluginManager;
import org.logSpin.process.GroovySpinProcess;

public class LogSpinLauncher {


    public static void main(String[] args) {
        GroovySpinProcess logProcess = new GroovySpinProcess();
        Spin spin = new LogSpinFactory(logProcess).provideSpin();
        PluginLoader pluginLoader = new PluginLoader(((DefaultPluginManager)spin
                .getPluginManager())
                .getPluginRegister());
        pluginLoader.loadAllInternalPlugin();
        pluginLoader.loadExternalPluginUnderFolder();
        if (args.length > 0) {
            spin.configure(args);
        } else {

        }
    }
}
