package org.LogSpin.launch;


import org.LogSpin.PluginLoader;
import org.LogSpin.Spin;
import org.LogSpin.factory.LogSpinFactory;
import org.LogSpin.plugin.DefaultPluginManager;
import org.LogSpin.plugin.PluginRegister;

public class LogSpinLauncher {


    public static void main(String[] args) {
        LogSpinFactory logSpinFactory = new LogSpinFactory();
        Spin spin = logSpinFactory.provideSpin();
        PluginRegister pluginRegister = ((DefaultPluginManager)spin.getPluginManager()).getPluginRegister();
        PluginLoader pluginLoader = new PluginLoader(pluginRegister);
        pluginLoader.loadAllPlugin();
        if (args.length > 0) {
            spin.configure(args);
        } else {

        }
    }
}
