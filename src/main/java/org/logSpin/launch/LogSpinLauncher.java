package org.logSpin.launch;


public class LogSpinLauncher {
    public static void main(String[] args) {
        LauncherHelper launcherHelper = new LauncherHelper();
        if (args.length > 0) {
            launcherHelper.run(args);
        }
    }
}
