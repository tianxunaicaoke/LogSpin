package org.logSpin.process;

import org.logSpin.LogSet;
import org.logSpin.SpinProcess;
import org.logSpin.core.AbstractDynamicObject;

public abstract class DefaultSpinProcess extends AbstractDynamicObject implements SpinProcess {

    private LogSet logSet;

    public LogSet getLogSet() {
        return this.logSet;
    }

    public void setLogSet(LogSet logSet) {
        this.logSet = logSet;
    }
}
