package org.logSpin;

public class AndroidPlugin implements Plugin<Spin> {

    @Override
    public void resolveCase(Spin spin) {

    }

    @Override
    public void apply(Spin spin) {
        if (!spin.getPluginManager().contain("BasePlugin")) {
            Plugin<Spin> basePlugin = spin.getPluginManager()
                    .getPluginById("BasePlugin");
            basePlugin.apply(spin);
            spin.getPluginContainer()
                    .addPlugin("BasePlugin", basePlugin);
        }
    }
}
