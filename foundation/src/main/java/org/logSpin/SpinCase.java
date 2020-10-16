package org.logSpin;

import java.util.List;

public interface SpinCase {
    void action(LogProcess logProcess);
    void addVariants(List<Variant> variants);
}
