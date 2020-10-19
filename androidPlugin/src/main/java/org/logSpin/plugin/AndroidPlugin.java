package org.logSpin.plugin;

import groovy.lang.Closure;
import org.logSpin.Plugin;
import org.logSpin.Spin;
import org.logSpin.core.ConfigureUtil;
import org.logSpin.spinCase.VariantCase;

public class AndroidPlugin implements Plugin<Spin> {
    private  AndroidExtension androidExtension;

    @Override
    public void resolveCase(Spin spin) {
        VariantCase variantCase = androidExtension.getScopeCase();
        variantCase.action(spin.getLogProcess());
        spin.getLogVariantManager().addVariant(variantCase.getVariants());
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
        androidExtension = new AndroidExtension();
    }

    @SuppressWarnings("unused")
    public void android(Closure<?> closure){
        ConfigureUtil.configureByObject(closure, androidExtension);
    }
}
