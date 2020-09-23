package org.logSpin.spinCase;

import org.logSpin.LogProcess;
import org.logSpin.SpinCase;

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

    private CaseState state;

    public CaseState getState() {
        return state;
    }

    public void setState(CaseState state) {
        this.state = state;
    }

    public boolean isReady(){
        return this.state == CaseState.Configured;
    }
}
