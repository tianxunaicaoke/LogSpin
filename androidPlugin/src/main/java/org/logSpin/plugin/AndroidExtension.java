package org.logSpin.plugin;

import org.logSpin.spinCase.VariantCase;

import java.util.Arrays;

@SuppressWarnings("unused")
public class AndroidExtension {

    private final VariantCase variantCase;

    public AndroidExtension() {
        variantCase = new VariantCase();
    }

    public VariantCase getScopeCase() {
        return variantCase;
    }

    public void process(String[] processes){
        Arrays.stream(processes).forEach(variantCase::addProcessId);
    }
}
