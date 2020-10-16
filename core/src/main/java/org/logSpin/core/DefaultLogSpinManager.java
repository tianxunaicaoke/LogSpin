package org.logSpin.core;

import org.logSpin.LogVariantManager;
import org.logSpin.Variant;

import java.util.ArrayList;
import java.util.List;

public class DefaultLogSpinManager implements LogVariantManager {
    @Override
    public void addVariant(List<Variant> variants) {

    }

    @Override
    public List<Variant> getVariant() {
        return new ArrayList<>();
    }
}
