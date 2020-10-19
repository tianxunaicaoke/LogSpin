package org.logSpin.core;

import org.logSpin.LogVariantManager;
import org.logSpin.SpinCase;
import org.logSpin.Variant;

import java.util.ArrayList;
import java.util.List;

public class DefaultLogSpinManager implements LogVariantManager {

    private final List<Variant> variants = new ArrayList<>();

    @Override
    public void addVariant(List<Variant> variants) {
        this.variants.addAll(variants);
    }

    @Override
    public void applyVariant(List<SpinCase> resolvedCase) {
        resolvedCase.forEach(spinCase ->
                spinCase.applyVariant(variants));

    }
}
