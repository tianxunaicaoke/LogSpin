package org.logSpin.plugin;

import groovy.lang.Closure;
import org.logSpin.Plugin;
import org.logSpin.Spin;
import org.logSpin.core.ConfigureUtil;

public class AndroidPlugin implements Plugin<Spin> {
    private  AndroidExtension androidExtension;

    @Override
    public void resolveCase(Spin spin) {
        spin.addPreAnalyseCase(androidExtension.getVariantCase());
    }

    @Override
    public void apply(Spin spin) {
        androidExtension = new AndroidExtension(spin);
    }

    @SuppressWarnings("unused")
    public void android(Closure<?> closure){
        ConfigureUtil.configureByObject(closure, androidExtension);
    }
}
