package org.logSpin.launch;


import org.logSpin.plugin.PluginLoader;
import org.logSpin.Spin;
import org.logSpin.factory.LogSpinFactory;
import org.logSpin.plugin.DefaultPluginManager;
import org.logSpin.core.DefaultLogProcess;
import org.logSpin.process.GroovyLogProcess;

public class LogSpinLauncher {


    public static void main(String[] args) {
        GroovyLogProcess logProcess = new GroovyLogProcess();
        Spin spin = new LogSpinFactory(logProcess).provideSpin();
        PluginLoader pluginLoader = new PluginLoader(((DefaultPluginManager)spin
                .getPluginManager())
                .getPluginRegister());
        pluginLoader.loadAllInternalPlugin();
        if (args.length > 0) {
            spin.configure(args);
        } else {

        }
    }
}
