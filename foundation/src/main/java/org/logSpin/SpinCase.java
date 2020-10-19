package org.logSpin;


import java.util.List;

public interface SpinCase {
    void action(LogProcess logProcess);
    void applyVariant(List<Variant> variants);
}
