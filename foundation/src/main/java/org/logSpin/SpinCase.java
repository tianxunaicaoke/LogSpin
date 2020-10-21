package org.logSpin;


import java.util.List;

public interface SpinCase {
    void action(SpinProcess spinProcess);
    void applyVariant(List<Variant> variants);
}
