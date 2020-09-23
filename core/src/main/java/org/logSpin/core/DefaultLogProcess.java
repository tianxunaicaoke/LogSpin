package org.logSpin.core;

import org.logSpin.LogSet;
import org.logSpin.LogProcess;

public abstract class DefaultLogProcess implements LogProcess {

    private LogSet logSet;

    public LogSet getLogSet() {
        return logSet;
    }

    public void setLogSet(LogSet logSet) {
        this.logSet = logSet;
    }
}
