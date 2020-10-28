package org.logSpin.launch;


import org.logSpin.annotation.Plugin;

@Plugin
public class LogSpinLauncher {
    public static void main(String[] args) {
        LauncherHelper launcherHelper = new LauncherHelper();
        if (args.length > 0) {
            //launcherHelper.run(args);
        }
    }
}
