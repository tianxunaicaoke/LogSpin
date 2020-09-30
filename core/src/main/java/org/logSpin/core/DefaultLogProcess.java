package org.logSpin.core;

import org.logSpin.LogSet;
import org.logSpin.LogProcess;

public abstract class DefaultLogProcess extends AbstractDynamicObject implements LogProcess {

    private LogSet logSet;

    public LogSet getLogSet() {
        return this.logSet;
    }

    public void setLogSet(LogSet logSet) {
        this.logSet = logSet;
    }
}
