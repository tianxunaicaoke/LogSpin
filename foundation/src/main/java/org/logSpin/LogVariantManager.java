package org.logSpin;

import java.util.List;

public interface LogVariantManager {
   void addVariant(List<Variant> variants);
   void applyVariant(List<SpinCase> resolvedCase);
}
