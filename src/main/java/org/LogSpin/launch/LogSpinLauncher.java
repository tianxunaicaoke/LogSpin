package org.LogSpin.launch;


import org.LogSpin.core.Spin;
import org.LogSpin.factory.ScriptRelatedFactory;

public class LogSpinLauncher {
    static ScriptRelatedFactory scriptRelatedFactory = new ScriptRelatedFactory();
    static Spin spin = scriptRelatedFactory.provideSpin();

    public static void main(String[] args) {
        if (args.length > 0) {
            spin.configure(args);
        } else {

        }
    }
}
