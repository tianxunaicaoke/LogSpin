package org.logSpin.plugin;

import org.logSpin.Spin;
import org.logSpin.spinCase.VariantCase;

import java.util.Arrays;

@SuppressWarnings("unused")
public class AndroidExtension {

    private final VariantCase variantCase;

    public AndroidExtension(Spin spin) {
        variantCase = new VariantCase(spin);
    }

    public VariantCase getVariantCase() {
        return variantCase;
    }

    public void process(String[] processes){
        Arrays.stream(processes).forEach(variantCase::addProcessId);
    }
}
