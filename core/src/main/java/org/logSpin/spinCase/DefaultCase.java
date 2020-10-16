package org.logSpin.spinCase;

import org.logSpin.Variant;
import org.logSpin.SpinCase;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public abstract class DefaultCase implements SpinCase {

    public enum CaseState {
        Created(0), Configured(1), Resolved(2);
        private final int index;

        CaseState(int i) {
            this.index = i;
        }

        public int getIndex() {
            return index;
        }
    }

    private CaseState state = CaseState.Created;

    private final List<Variant> variants = new ArrayList<>();

    @Override
    public void addVariants(List<Variant> variants) {
        variants.addAll(variants);
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public CaseState getState() {
        return state;
    }

    public void setState(CaseState state) {
        this.state = state;
    }

    public boolean isReady(){
        return this.state == CaseState.Resolved;
    }
}
